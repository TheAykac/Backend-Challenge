package com.example.backendchallenge.core.utilities.messages;

public class BusinessMessage {

    public static class GlobalMessages {

        public static final String DATA_LISTED_SUCCESSFULLY = "Data Listed Successfully";

        public static final String DATA_ADDED_SUCCESSFULLY = "Data Added Successfully";
        public static final String DATA_UPDATED_SUCCESSFULLY = "Data updated Successfully, dataId: ";
        public static final String DATA_DELETED_SUCCESSFULLY = "Data deleted successfully, dataId: ";
        public static final String DATA_EMPTY = "Data is Empty ";
    }

    public static class Company{

        public static final String COMPANY_ID_NOT_FOUND = "company Id Not Found companyId: ";
        public static final String COMPANY_LIST_EMPTY="This List is Empty";

    }
    public static class Employee{
        public static final String BABY_ID_NOT_FOUND = "Employee Id Not Found employeeId: ";
        public static final String Employee_LIST_EMPTY="This List is Empty";
    }


}
