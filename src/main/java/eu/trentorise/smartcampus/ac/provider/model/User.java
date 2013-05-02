/**
 *    Copyright 2012-2013 Trento RISE
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package eu.trentorise.smartcampus.ac.provider.model;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author Viktor Pravdin
 */
@XmlRootElement(name = "User")
public class User extends AcObject {

	private List<Attribute> attributes;
	private String authToken;
	private long expTime;
	private long socialId;
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

	public long getExpTime() {
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
		if ((this.authToken == null) ? (other.authToken != null)
				: !this.authToken.equals(other.authToken)) {
			return false;
		}
		if ((this.id == null) ? (other.id != null) : !this.id.equals(other.id)) {
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

	@Override
	public String toString() {
		return "User{id=" + id + ", authToken=" + authToken + ", expTime="
				+ expTime + ", socialId=" + socialId + " ,attributes="
				+ attributes + '}';
	}

	public long getSocialId() {
		return socialId;
	}

	public void setSocialId(long socialId) {
		this.socialId = socialId;
	}

}
