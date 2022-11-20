package jedis;

import redis.clients.jedis.Jedis;

public class RedisHash {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Jedis jedis = new Jedis();
		
		//push data to hash in redis
		jedis.hset("project", "ProjectName", "RedisProject");
		jedis.hset("project", "Language", "Java");
		jedis.hset("project", "RegistryDate", "25/10/2022");
		
		//check data was saved in redis
		System.out.println("Result Hash: " + jedis.hgetAll("project"));
	}

}
