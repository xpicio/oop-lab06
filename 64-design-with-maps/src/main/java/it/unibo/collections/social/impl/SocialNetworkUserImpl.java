/**
 * 
 */
package it.unibo.collections.social.impl;

import it.unibo.collections.social.api.SocialNetworkUser;
import it.unibo.collections.social.api.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 
 * This will be an implementation of
 * {@link SocialNetworkUser}:
 * 1) complete the definition of the methods by following the suggestions
 * included in the comments below.
 * 
 * @param <U>
 *            Specific {@link User} type
 */
public final class SocialNetworkUserImpl<U extends User> extends UserImpl implements SocialNetworkUser<U> {

    /*
     *
     * [FIELDS]
     *
     * Define any necessary field
     *
     * In order to save the people followed by a user organized in groups, adopt
     * a generic-type Map: think of what type of keys and values would best suit the
     * requirements
     */
    private final Map<String, Set<U>> followedUsers;

    /**
     * Builds a user participating in a social network.
     *
     * @param name
     *                the user firstname
     * @param surname
     *                the user lastname
     * @param userAge
     *                user's age
     * @param user
     *                alias of the user, i.e. the way a user is identified on an
     *                application
     */
    public SocialNetworkUserImpl(final String name, final String surname, final String user, final int userAge) {
        super(name, surname, user, userAge);

        this.followedUsers = new HashMap<>();
    }

    /**
     * Builds a new user participating in a social network with default age field
     * not set. The default value is -1.
     * 
     * @param name
     *                the user firstname
     * @param surname
     *                the user lastname
     * @param user
     *                alias of the user, i.e. the way a user is identified on an
     *                application
     */
    public SocialNetworkUserImpl(final String name, final String surname, final String user) {
        this(name, surname, user, -1);
    }

    @Override
    public boolean addFollowedUser(final String circle, final U user) {
        Set<U> users = this.followedUsers.get(circle);

        // sanity check
        // when no group exist
        if (users == null) {
            users = new HashSet<>();
        }

        final boolean userDoesNotExist = users.add(user);

        this.followedUsers.put(circle, users);

        return userDoesNotExist;
    }

    /**
     *
     * [NOTE] If no group with groupName exists yet, this implementation must
     * return an empty Collection.
     */
    @Override
    public Collection<U> getFollowedUsersInGroup(final String groupName) {
        Collection<U> emptyUsers = Collections.emptyList();
        Collection<U> users = this.followedUsers.get(groupName);

        // Defensive copy with immutable Collection will break the test 💣
        // dwashFriends.add(asmith); can not be used
        //
        // Exception in thread "main" java.lang.UnsupportedOperationException
        // at
        // java.base/java.util.Collections$UnmodifiableCollection.add(Collections.java:1091)
        // at
        // it.unibo.collections.social.TestSocialNetworkUser.main(TestSocialNetworkUser.java:80)
        //
        // return users == null ? emptyUsers :
        // Collections.unmodifiableCollection(users);

        return users == null ? emptyUsers : new ArrayList<>(users);
    }

    @Override
    public List<U> getFollowedUsers() {
        Set<U> users = new HashSet<>();

        for (String groupName : this.followedUsers.keySet()) {
            users.addAll(this.followedUsers.get(groupName));
        }

        return new ArrayList<>(users);
    }
}
