package ru.mike.videorecognition;

import android.test.ApplicationTestCase;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by Shishov M.V. on 10/07/2015.
 */

public class GlobalDataTest extends ApplicationTestCase<GlobalData> {

    private GlobalData globalData;

    public GlobalDataTest() {
        super(GlobalData.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        createApplication();
        globalData = getApplication();
        assertNotNull("GlobalData is NULL", globalData);
    }

    @Test
    public void testGetRootPath() throws Exception {
        assertNotNull("rootPath is NULL", globalData.getRootPath());
        assertNotSame("rootPath is not String", new String(), globalData.getRootPath());
        assertFalse("rootPath is Empty", globalData.getRootPath().isEmpty());
    }

    @Test
    public void testGetDBPath() throws Exception {
        assertNotNull("rootPath is NULL", globalData.getDBPath());
        assertNotSame("rootPath is not String", new String(), globalData.getDBPath());
        assertFalse("rootPath is Empty", globalData.getDBPath().isEmpty());
    }

    @Test
    public void testGetFilesPath() throws Exception {
        assertNotNull("rootPath is NULL", globalData.getFilesPath());
        assertNotSame("rootPath is not String", new String(), globalData.getFilesPath());
        assertFalse("rootPath is Empty", globalData.getFilesPath().isEmpty());
    }
}