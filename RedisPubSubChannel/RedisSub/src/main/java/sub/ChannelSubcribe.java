package sub;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;

public class ChannelSubcribe {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Jedis jedis = null;

		try {

			jedis = new Jedis();

			/* Creating JedisPubSub object for subscribing with channels */
			JedisPubSub jedisPubSub = new JedisPubSub() {

				@Override
				public void onMessage(String channel, String message) {
					System.out.println(channel + " has sent a message : " + message);
					if (channel.equals("Channel1")) {
						/* Unsubscribe from channel 1 after first message is received. */
						unsubscribe(channel);
					}
				}

				@Override
				public void onSubscribe(String channel, int subscribedChannels) {
					System.out.println("Client is Subscribed to: " + channel);
					System.out.println("Client is Subscribed to " + subscribedChannels + " no. of channels");
				}

				@Override
				public void onUnsubscribe(String channel, int subscribedChannels) {
					System.out.println("Client is Unsubscribed from: " + channel);
				}

			};

			/* Subscribing to channel C1 and C2 */
			jedis.subscribe(jedisPubSub, "Channel1", "Channel2");

		} catch (Exception ex) {

			System.out.println("Exception : " + ex.getMessage());

		} finally {

			if (jedis != null) {
				jedis.close();
			}
		}
	}

}
