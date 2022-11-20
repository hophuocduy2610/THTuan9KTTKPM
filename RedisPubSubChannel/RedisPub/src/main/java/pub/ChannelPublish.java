package pub;

import redis.clients.jedis.Jedis;

public class ChannelPublish {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Jedis jedis = null;
        
	    try {           
	        /* Creating Jedis object for connecting with redis server */
	        jedis = new Jedis();
	             
	        /* Publishing message to channel C1 */
	        jedis.publish("Channel1", "First message to channel C1");
	             
	        /* Publishing message to channel C2 */
	        jedis.publish("Channel2", "First message to channel C2");
	         
	        /* Publishing message to channel C1 */
	        jedis.publish("Channel1", "Second message to channel C1");
	             
	        /* Publishing message to channel C2 */
	        jedis.publish("Channel2", "Second message to channel C2");
	         
	    } catch(Exception ex) {         
	             
	        System.out.println("Exception : " + ex.getMessage());
	    } finally {
	             
	        if(jedis != null) {
	          jedis.close();
	        }       
	    }
	}

}
