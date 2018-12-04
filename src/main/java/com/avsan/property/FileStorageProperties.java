package com.avsan.property;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

import com.avsan.constant.PropConstant;

@ConfigurationProperties
public class FileStorageProperties {
	@Value(PropConstant.UPLOAD_DIR)
    private String uploadDir;

	@Value(PropConstant.USER_ID)
    private String userId;
	
	@Value(PropConstant.USER_KEY)
    private String key;
	
	@Value(PropConstant.USER_ROLE)
    private String role;
	
    public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getUploadDir() {
        return uploadDir;
    }

    public void setUploadDir(String uploadDir) {
        this.uploadDir = uploadDir;
    }
}
