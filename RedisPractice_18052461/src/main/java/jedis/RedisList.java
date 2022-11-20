package jedis;

import redis.clients.jedis.Jedis;

public class RedisList {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Jedis jedis = new Jedis();
		
		//push data to list in redis
		jedis.lpush("programminglanguages", "C#");
		jedis.lpush("programminglanguages", "Java");
		jedis.lpush("programminglanguages", "HTML");
		jedis.lpush("programminglanguages", "CSS");
		
		//check data was saved in redis
		System.out.println(jedis.lrange("programminglanguages", 0, 10));
	}

}
