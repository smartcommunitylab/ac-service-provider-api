/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.trentorise.smartcampus.ac.provider;

import java.util.List;

import javax.jws.WebService;

import eu.trentorise.smartcampus.ac.provider.model.Attribute;
import eu.trentorise.smartcampus.ac.provider.model.User;

/**
 *
 * @author Viktor Pravdin
 */
@WebService
public interface AcService {
    
    /**
     * Reads the user by the authentication token
     * @param authToken The authentication token
     * @return The user that has the given token or null if such user doesn't exist
     * @throws AcServiceException
     */
    User getUserByToken(String authToken) throws AcServiceException;
    
    /**
     * Reads the users that have the given attributes
     * @param attributes The attributes map
     * @return The list of users that have the given attributes
     * @throws AcServiceException
     */
    List<User> getUsersByAttributes(List<Attribute> attributes) throws AcServiceException;

    /**
     * Checks if the user is still valid
     * @param authToken The authentication token
     * @return True if the authentication token is valid and not expired, false otherwise
     * @throws AcServiceException
     */
    boolean isValidUser(String authToken) throws AcServiceException;

    /**
     * Fetches the user attributes that match the given authority and the key.
     * If neither is given then it will return all attributes of the user, if
     * the authority is given then it will return only the attributes of that
     * authority and if the key is also given then it will return only the attributes
     * of that authority that have the given key.
     * @param authToken The authentication token of the user
     * @param authority The authority name
     * @param key The key of the attribute
     * @return The set of attributes that match the parameters
     * @throws AcServiceException
     */
    List<Attribute> getUserAttributes(String authToken, String authority, String key) throws AcServiceException;
}
