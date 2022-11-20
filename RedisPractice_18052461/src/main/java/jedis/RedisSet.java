package jedis;

import redis.clients.jedis.Jedis;

public class RedisSet {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Jedis jedis = new Jedis();
		
		//Add Set to Redis
		jedis.sadd("Language", "Java");
		jedis.sadd("Project", "RedisProject");
		jedis.sadd("Project", "SpringProject");
		jedis.sadd("RegistryDate", "20/10/2022");
		
		//Read Set in Redis and show in console
		System.out.println("Member in Language Set: " + jedis.smembers("Language"));
		System.out.println("Member in Project Set: " + jedis.smembers("Project"));
		
	}

}
