/**
 * 
 */
package it.unibo.collections.social;

import it.unibo.collections.social.api.SocialNetworkUser;
import it.unibo.collections.social.api.User;
import it.unibo.collections.social.impl.SocialNetworkUserImpl;
import it.unibo.collections.social.impl.UserImpl;

import java.util.Collection;

/**
 * This is going to act as a test for
 * {@link SocialNetworkUserImpl}.
 * 
 * 1) Complete the test as per comments below
 * 
 * 2) Run it: every test must return true.
 */
public final class TestSocialNetworkUser {

    private static final String WRITERS = "writers";
    private static final int KEVIN_BACON_AGE = 56;
    private static final int DENZEL_WASHINGTON_AGE = 59;
    private static final int MALCOM_GLADWELL_AGE = 51;
    private static final int NICHOLAS_TALEB_AGE = 54;

    private TestSocialNetworkUser() {
    }

    /**
     * This is going to act as a test for
     * {@link SocialNetworkUserImpl}.
     * 
     * @param args
     *             ignored
     */
    public static void main(final String... args) {
        /*
         * Create 5 social network users (SocialNetworkUser):
         * 
         * * Kevin Bacon, kbacon, 56
         * 
         * * Denzel Washington, dwashington, 59
         * 
         * * Malcom Gladwell, mgladwell, 51
         * 
         * * Nicholas Taleb, ntaleb, 54
         * 
         * And one regular UserImpl (User)
         * 
         * * Adam Smith, asmith, (no age)
         */
        final SocialNetworkUser<User> kbacon = new SocialNetworkUserImpl<>("Kevin", "Bacon", "kbacon", KEVIN_BACON_AGE);
        final SocialNetworkUser<User> dwashington = new SocialNetworkUserImpl<>("Denzel", "Washington", "dwashington",
                DENZEL_WASHINGTON_AGE);
        final SocialNetworkUser<User> mgladwell = new SocialNetworkUserImpl<>("Malcom", "Gladwell", "mgladwell",
                MALCOM_GLADWELL_AGE);
        final SocialNetworkUser<User> ntaleb = new SocialNetworkUserImpl<>("Nicholas", "Taleb", "ntaleb",
                NICHOLAS_TALEB_AGE);
        final User asmith = new UserImpl("Adam", "Smith", "asmith");
        /*
         * Make people follow each other
         */
        mgladwell.addFollowedUser("acquaintances", ntaleb);
        dwashington.addFollowedUser("myths", asmith);
        dwashington.addFollowedUser(WRITERS, ntaleb);
        dwashington.addFollowedUser("colleagues", kbacon);
        dwashington.addFollowedUser(WRITERS, mgladwell);
        /*
         * No test should fail
         */
        assertTrue("smith has not set any age at all", !asmith.isAgeDefined());
        final Collection<User> kbaconFriends = kbacon.getFollowedUsersInGroup("Malcom");
        assertTrue("K Bacon has no followed people called Malcom", kbaconFriends.isEmpty());
        final Collection<User> mgladFriends = mgladwell.getFollowedUsersInGroup("Close friends");
        assertTrue("M Gladwell has not set yet any group called \"Close friends\"", mgladFriends.isEmpty());
        final Collection<User> dwashFriends = dwashington.getFollowedUsersInGroup(WRITERS);
        assertTrue("Denzel has 2 followed people in group \"" + WRITERS + "\"", dwashFriends.size() == 2);
        /*
         * Adding another friend to Denzel's "writers" group
         */
        dwashFriends.add(asmith);
        /*
         * The above operation *MUST* have no effect on Denzel's profile itself:
         * STILL TWO PEOPLE in denzel's group called writers
         */
        assertTrue(
                "Denzel has STILL 2 followed people in group \"" + WRITERS + "\"",
                dwashington.getFollowedUsersInGroup(WRITERS).size() == 2);
    }

    private static void assertTrue(final String message, final boolean value) {
        if (value) {
            System.out.println("OK: " + message); // NOPMD
        } else {
            throw new AssertionError("ERROR, the following is false: " + message);
        }
    }
}
