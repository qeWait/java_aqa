package org.example.task_13;

import org.apache.log4j.Logger;
import org.testng.ISuite;
import org.testng.ISuiteListener;

public class SuiteListener implements ISuiteListener {
    protected final Logger LOGGER = Logger.getLogger(this.getClass());

    @Override
    public void onFinish(ISuite iSuite){
        System.out.println(iSuite.getName() + " finished");

    }

}
