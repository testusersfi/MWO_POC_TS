DECLARE
   tmp_wo_no_ IFSAPP.work_order.wo_no%TYPE;
   
   PROCEDURE Validate_Value (
      value_      IN VARCHAR2,
      error_desc_ IN VARCHAR2)
   IS
   BEGIN
      IF (value_ IS NULL) THEN
         IFSAPP.Error_SYS.Record_General('WorkOrder', 'VALNOTFOUND: :P1', error_desc_);
      END IF;
   END Validate_Value;
   
   PROCEDURE Create_Test_Work_Order (
      wo_no_ OUT NUMBER)
   IS
      info_       VARCHAR2(4000);
      objid_      VARCHAR2(2000);
      objversion_ VARCHAR2(2000);
      attr_       VARCHAR2(4000);
      contract_   IFSAPP.work_order.contract%TYPE;
      company_    IFSAPP.work_order.company%TYPE;
      mch_code_   IFSAPP.work_order.mch_code%TYPE;
      org_code_   IFSAPP.work_order.org_code%TYPE;
      
      CURSOR get_mch_code IS
         SELECT mch_code
         FROM   IFSAPP.maintenance_object_lov
         WHERE  connection_type = 'EQUIPMENT'
         AND    (operational_status_db != 'SCRAPPED' OR operational_status_db IS NULL)
         AND    (obj_level IS NULL OR (obj_level IS NOT NULL AND IFSAPP.Equipment_Object_Level_API.Get_Create_Wo(obj_level) = 'TRUE'))
         AND    contract = contract_
         FETCH FIRST ROW ONLY;
         
      CURSOR get_org_code IS
         SELECT org_code
         FROM   IFSAPP.org_code_allowed_site_lov
         WHERE  contract = contract_
         FETCH FIRST ROW ONLY;
   BEGIN
      contract_ := IFSAPP.User_Default_API.Get_Contract;
      Validate_Value(contract_, 'User ' || IFSAPP.Fnd_Session_API.Get_Fnd_User || ' does not have a default site.');
      
      company_  := IFSAPP.Site_API.Get_Company(contract_);
      
      -- Create work order
      OPEN get_mch_code;
      FETCH get_mch_code INTO mch_code_;
      CLOSE get_mch_code;
      Validate_Value(mch_code_, 'Site ' || contract_ || ' does not have any objects suitable for work orders.');
      
      OPEN get_org_code;
      FETCH get_org_code INTO org_code_;
      CLOSE get_org_code;
      Validate_Value(mch_code_, 'Site ' || contract_ || ' does not have an active maintenance organization.');
      
      IFSAPP.Active_Separate_API.New__(info_, objid_, objversion_, attr_, 'PREAPRE');
      
      IFSAPP.Client_SYS.Set_Item_Value('CONTRACT',             contract_, attr_); 
      IFSAPP.Client_SYS.Set_Item_Value('ERR_DESCR',            'Test ' || TO_CHAR(CURRENT_TIMESTAMP, 'YYYY-MM-DD HH24:MI:SSxFF TZH:TZM'), attr_); 
      IFSAPP.Client_SYS.Set_Item_Value('REPORTED_BY',          IFSAPP.Person_Info_API.Get_Id_For_Current_User, attr_);
      IFSAPP.Client_SYS.Set_Item_Value('MCH_CODE_CONTRACT',    contract_, attr_); 
      IFSAPP.Client_SYS.Set_Item_Value('MCH_CODE',             mch_code_, attr_); 
      IFSAPP.Client_SYS.Set_Item_Value('ORG_CODE',             org_code_, attr_); 
      IFSAPP.Client_SYS.Set_Item_Value('REG_DATE',             SYSDATE, attr_); 
      IFSAPP.Client_SYS.Set_Item_Value('OPS_FOLLOW_WO_STATUS', 'TRUE', attr_); 
      IFSAPP.Client_SYS.Set_Item_Value('CUST_ORDER_TYPE',      'SEO', attr_); 
      IFSAPP.Client_SYS.Set_Item_Value('FAULT_REP_FLAG',       '0', attr_); 
      IFSAPP.Client_SYS.Set_Item_Value('COMPANY',              company_, attr_); 
      IFSAPP.Client_SYS.Set_Item_Value('REPORTED_BY_ID',       IFSAPP.Company_Emp_API.Get_Max_Employee_Id(company_, IFSAPP.Person_Info_API.Get_Id_For_Current_User), attr_); 
      IFSAPP.Client_SYS.Set_Item_Value('CONNECTION_TYPE_DB',   'EQUIPMENT', attr_); 
      IFSAPP.Client_SYS.Set_Item_Value('PM_TYPE_DB',           IFSAPP.Pm_Type_API.DB_SEPARATE_ACTION, attr_);

      IFSAPP.Active_Separate_API.New__(info_, objid_, objversion_, attr_, 'DO');
         
      wo_no_ := IFSAPP.Client_SYS.Get_Item_Value_To_Number('WO_NO', attr_, 'WorkOrder');
      
      -- Transfer WO to Mobile
      IFSAPP.Mobile_Work_Order_Util_API.Generate_Wo_To_Mobile(
         wo_no_, 
         IFSAPP.Person_Info_API.Get_Id_For_Current_User,
         emp_id_ => IFSAPP.Company_Emp_API.Get_Max_Employee_Id(company_, IFSAPP.Person_Info_API.Get_Id_For_Current_User));
   END Create_Test_Work_Order;
BEGIN
   Create_Test_Work_Order(tmp_wo_no_);
   :out_result := tmp_wo_no_;
   --DBMS_OUTPUT.PUT_LINE('WO No.: ' || tmp_wo_no_);
END;
