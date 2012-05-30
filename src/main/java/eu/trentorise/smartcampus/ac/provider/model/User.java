/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.trentorise.smartcampus.ac.provider.model;

import java.util.List;
import java.util.Map;

/**
 *
 * @author Viktor Pravdin
 */
public class User extends AcObject {

    private List<Attribute> attributes;
    private String authToken;
    private long expTime;
    private Integer hash;

    public List<Attribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<Attribute> attributes) {
        this.attributes = attributes;
    }

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public long getExpDate() {
        return expTime;
    }

    public void setExpTime(long expTime) {
        this.expTime = expTime;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if ((this.authToken == null) ? (other.authToken != null) : !this.authToken.
                equals(other.authToken)) {
            return false;
        }
        if ((this.id == null) ? (other.id != null) : !this.id.
                equals(other.id)) {
            return false;
        }
        return true;
    }
    

    @Override
    public int hashCode() {
        if (hash == null) {
            hash = 7;
            hash = 97 * hash + (this.id != null ? this.id.hashCode() : 0);
        }
        return hash;
    }
}
