package org.example.task_13;

import org.apache.log4j.Logger;
import org.testng.IExecutionListener;

public class ExecutionListener implements IExecutionListener {
    protected final Logger LOGGER = Logger.getLogger(this.getClass());

    @Override
    public void onExecutionFinish() {
        LOGGER.info("jj");
    }
}
