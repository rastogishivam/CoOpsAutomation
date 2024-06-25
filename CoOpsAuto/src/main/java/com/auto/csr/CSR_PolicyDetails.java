package com.auto.csr;

import com.microsoft.playwright.Page;
import com.org.coops.base.BaseWebPage;

public class CSR_PolicyDetails extends BaseWebPage {

    private Page driver;
    public CSR_PolicyDetails(Page page) {
        super(page);
        driver = page;
    }
}
