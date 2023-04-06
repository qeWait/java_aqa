package org.example.task_13;

import org.testng.ISuite;
import org.testng.ISuiteListener;

public class SuiteListener implements ISuiteListener {
    @Override
    public void onStart(ISuite iSuite){
        System.out.println(iSuite.getName() + " started");

    }
    @Override
    public void onFinish(ISuite iSuite){
        System.out.println(iSuite.getName() + " finished");

    }

}
