/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.trentorise.smartcampus.ac.provider;

import eu.trentorise.smartcampus.ac.provider.model.Attribute;
import eu.trentorise.smartcampus.ac.provider.model.Authority;
import eu.trentorise.smartcampus.ac.provider.model.User;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import javax.jws.WebService;

/**
 *
 * @author Viktor Pravdin
 */
@WebService
public interface AcProviderService {
    
    /**
     * Creates a new user and stores it
     * @param authToken The authentication token of the user
     * @param expDate The expiration date of the token
     * @param attributes The user attributes
     * @return 
     */
    User createUser(String authToken, long expDate,
            List<Attribute> attributes);

    /**
     * Reads the user by the authentication token
     * @param authToken The authentication token
     * @return The user that has the given token or null if such user doesn't exist
     */
    User getUserByToken(String authToken);
    
    /**
     * Reads the users that have the given attributes
     * @param attributes The attributes map
     * @return The list of users that have the given attributes
     */
    List<User> getUsersByAttributes(List<Attribute> attributes);

    /**
     * Checks if the user is still valid
     * @param authToken The authentication token
     * @return True if the authentication token is valid and not expired, false otherwise
     */
    boolean isValidUser(String authToken);

    /**
     * Completely deletes the user data
     * @param authToken The authentication token of the user
     * @return true if the user was deleted
     */
    boolean removeUser(String authToken);

    /**
     * Updates the user data with the given values. If a new value for an
     * already existing value is not specified then the old value remains
     * untouched.
     *
     * @param userId The ID of the user. Must not be null
     * @param authToken The new authentication token or null if the token
     * shouldn't be updated
     * @param expTime The new expiration time or null if it shouldn't be
     * updated. Must not be null if a new authentication token is present.
     * Ignored if the auth token is null.
     * @param attributes The map of the attributes. The existing attributes are
     * updated, the new ones are added, the old ones are kept intact.
     * @throws IllegalArgumentException if the user with the given ID doesn't
     * exist or if the expiration time is not specified for an authentication
     * token
     */
    void updateUser(long userId, String authToken, Long expTime,
            List<Attribute> attributes);

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
     */
    List<Attribute> getUserAttributes(String authToken, String authority,
            String key);

    String generateAuthToken();

    Collection<Authority> getAuthorities();

    Authority getAuthorityByName(String name);

    void createAuthority(Authority auth);

    Authority getAuthorityByUrl(String name);

}
