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
package eu.trentorise.smartcampus.ac.provider;

import java.util.List;

import javax.jws.WebService;

import eu.trentorise.smartcampus.ac.provider.model.Attribute;
import eu.trentorise.smartcampus.ac.provider.model.User;

/**
 * The interface describes read-only operations on a user
 * 
 * @author Viktor Pravdin
 */
@WebService
public interface AcService {

	/**
	 * Reads the user by the authentication token
	 * 
	 * @param authToken
	 *            The authentication token
	 * @return The user that has the given token or null if such user doesn't
	 *         exist
	 * @throws AcServiceException
	 */
	User getUserByToken(String authToken) throws AcServiceException;

	/**
	 * Reads the users that have the given attributes
	 * 
	 * @param attributes
	 *            The attributes map
	 * @return The list of users that have the given attributes
	 * @throws AcServiceException
	 */
	List<User> getUsersByAttributes(List<Attribute> attributes)
			throws AcServiceException;

	/**
	 * Checks if the user is still valid
	 * 
	 * @param authToken
	 *            The authentication token
	 * @return True if the authentication token is valid and not expired, false
	 *         otherwise
	 * @throws AcServiceException
	 */
	boolean isValidUser(String authToken) throws AcServiceException;

	/**
	 * Fetches the user attributes that match the given authority and the key.
	 * If neither is given then it will return all attributes of the user, if
	 * the authority is given then it will return only the attributes of that
	 * authority and if the key is also given then it will return only the
	 * attributes of that authority that have the given key.
	 * 
	 * @param authToken
	 *            The authentication token of the user
	 * @param authority
	 *            The authority name
	 * @param key
	 *            The key of the attribute
	 * @return The set of attributes that match the parameters
	 * @throws AcServiceException
	 */
	List<Attribute> getUserAttributes(String authToken, String authority,
			String key) throws AcServiceException;

	/**
	 * Set the attribute for user, the attribute is added to user attributes (if
	 * not present) or updated (if already present). An exception is threw if
	 * userId or authority relative to attribute are not present
	 * 
	 * @param userId
	 *            id of user
	 * @param attribute
	 *            attribute to set
	 * @throws AcServiceException
	 */
	void setAttribute(long userId, Attribute attribute)
			throws AcServiceException;
}
