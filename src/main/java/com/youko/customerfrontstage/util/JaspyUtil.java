package com.youko.customerfrontstage.util;

import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.EnvironmentStringPBEConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Properties;

public class JaspyUtil {
    @Autowired
    EnvironmentStringPBEConfig config;
    static Properties properties = YmlUtils.getYml("application-dev.yml");
    static String password = properties.getProperty("jasypt.encryptor.password");
    static String algorithm = properties.getProperty("jasypt.encryptor.algorithm");

    //给明码加密
    public static String encryptWithMD5(String plainText){
        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        // 2. 加解密配置
        EnvironmentStringPBEConfig config = new EnvironmentStringPBEConfig();
        config.setAlgorithm(algorithm);
        config.setPassword(password);
        encryptor.setConfig(config);
        // 3. 加密
        return encryptor.encrypt(plainText);

    }
    public static String decryptWithMD5(String encryptedText) {
        // 1. 创建加解密工具实例
        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        // 2. 加解密配置
        EnvironmentStringPBEConfig config = new EnvironmentStringPBEConfig();
        config.setAlgorithm(algorithm);
        config.setPassword(password);
        encryptor.setConfig(config);
        // 3. 解密
        return encryptor.decrypt(encryptedText);
    }
}
