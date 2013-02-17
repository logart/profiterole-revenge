package com.exigen.common.service;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.File;

import static org.mockito.Mockito.when;

/**
 * Created by IntelliJ IDEA.
 * User: Admin
 * Date: 16.02.13
 * Time: 21:47
 * To change this template use File | Settings | File Templates.
 */
public class ImageServiceImplTest {
    @Mock
    ImageServiceImpl imageService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }
    
    @Test
    public void testPostImage() throws Exception {
        File file=new File("fghfgh");
     when(imageService.postImage(file)).thenReturn("fgfh");
        Assert.assertNotNull(imageService.postImage(file));
    }
}
