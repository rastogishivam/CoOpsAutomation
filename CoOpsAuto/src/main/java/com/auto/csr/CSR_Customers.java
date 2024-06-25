package com.auto.csr;

import com.microsoft.playwright.Page;
import com.org.coops.base.BaseWebPage;

public class CSR_Customers extends BaseWebPage {
    private Page driver;
    public CSR_Customers(Page page) {
        super(page);
        driver = page;
    }


}
