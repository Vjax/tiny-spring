package com.example.beans.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * 内部定位资源的接口
 */
public interface Resource {

    InputStream getInputStream() throws IOException;
}
