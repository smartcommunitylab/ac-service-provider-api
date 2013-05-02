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

import java.util.Collection;
import java.util.List;

import javax.jws.WebService;

import eu.trentorise.smartcampus.ac.provider.model.Attribute;
import eu.trentorise.smartcampus.ac.provider.model.Authority;
import eu.trentorise.smartcampus.ac.provider.model.User;

/**
 * The interface describes operations managed by ac-provider-service
 * 
 * @author Viktor Pravdin
 */
@WebService
public interface AcProviderService extends AcService {

	/**
	 * Creates a new user and stores it
	 * 
	 * @param authToken
	 *            The authentication token of the user
	 * @param expDate
	 *            The expiration date of the token
	 * @param attributes
	 *            The user attributes
	 * @return
	 */
	User createUser(String authToken, long expDate, List<Attribute> attributes)
			throws AcServiceException;

	/**
	 * Completely deletes the user data
	 * 
	 * @param authToken
	 *            The authentication token of the user
	 * @return true if the user was deleted
	 */
	boolean removeUser(String authToken) throws AcServiceException;

	/**
	 * Updates the user data with the given values. If a new value for an
	 * already existing value is not specified then the old value remains
	 * untouched.
	 * 
	 * @param userId
	 *            The ID of the user. Must not be null
	 * @param authToken
	 *            The new authentication token or null if the token shouldn't be
	 *            updated
	 * @param expTime
	 *            The new expiration time or null if it shouldn't be updated.
	 *            Must not be null if a new authentication token is present.
	 *            Ignored if the auth token is null.
	 * @param attributes
	 *            The map of the attributes. The existing attributes are
	 *            updated, the new ones are added, the old ones are kept intact.
	 * @throws IllegalArgumentException
	 *             if the user with the given ID doesn't exist or if the
	 *             expiration time is not specified for an authentication token
	 */
	void updateUser(long userId, String authToken, Long expTime,
			List<Attribute> attributes) throws AcServiceException;

	/**
	 * Create/update short-living token for the specified user.
	 * @param userId
	 * @param expTime
	 * @throws AcServiceException
	 * @throws IllegalArgumentException
	 *             if the user with the given ID doesn't exist or if the
	 *             expiration time is not specified for an authentication token
	 */
	String createSessionToken(long userId, Long expTime) throws AcServiceException;
	
	String generateAuthToken() throws AcServiceException;

	Collection<Authority> getAuthorities() throws AcServiceException;

	Authority getAuthorityByName(String name) throws AcServiceException;

	void createAuthority(Authority auth) throws AcServiceException;

	void updateAuthority(Authority auth) throws AcServiceException;

	Authority getAuthorityByUrl(String name) throws AcServiceException;

	/**
	 * Reads the users that have the given attributes
	 * 
	 * @param attributes
	 *            The attributes map
	 * @return The list of users that have the given attributes
	 * @throws AcServiceException
	 */
	List<User> getUsersByAttributes(List<Attribute> attributes) throws AcServiceException;

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
