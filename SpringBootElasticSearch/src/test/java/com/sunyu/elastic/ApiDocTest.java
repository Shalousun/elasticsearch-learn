package com.sunyu.elastic;

import com.power.doc.builder.ApiDocBuilder;
import com.power.doc.model.ApiConfig;
import org.junit.Test;

/**
 * @author yu 2018/9/14.
 */
public class ApiDocTest {

    @Test
    public void testBuilderControllersApi() {
        ApiConfig config = new ApiConfig();
        config.setServerUrl("http://localhost:8080");
        config.setStrict(true);
        config.setAllInOne(true);//true则将所有接口合并到一个AllInOne中markdown中，错误码合并到最后
        config.setOutPath("d:\\md");
        ApiDocBuilder.builderControllersApi(config);
    }
}
