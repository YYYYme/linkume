package com.cn.linkume;


public class TestActivemq {/*

	// queue
	// producer
	@Test
	public void testQueueProducer() throws Exception {
		//1.创建一个连接工厂对象ConnectionFactory,需要指定mq服务的ip和端口
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://192.168.145.1:61616");
		//2.使用ConnectionFactory创建一个链接Connection对象
		Connection connection = connectionFactory.createConnection();
		//3.开启连接，调用Connection对象的start方法
		connection.start();
		//4.使用Connection对象创建一个Session对象
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

		//5.使用Session对象创建一个Destination对象，两种形式，queue，topic,
		Queue queue = session.createQueue("q");

		//6.使用Session对象创建一个Producer对象
		MessageProducer messageProducer = session.createProducer(queue);

		//7.创建一个TextMessage对象
		TextMessage testMessage = session.createTextMessage("aaa");

		//8.发送消息
		messageProducer.send(testMessage);

		//9.关闭资源
		messageProducer.close();
		connection.close();
		session.close();

	}
	
	@Test
	public void testQueueConsumer() throws Exception {
		ConnectionFactory cf = new ActiveMQConnectionFactory("tcp://192.168.1.39:61616");
		Connection Connection = cf.createConnection();
		Connection.start();
		Session session = Connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		Queue queue = session.createQueue("q");
		MessageConsumer consumer = session.createConsumer(queue);
		consumer.setMessageListener(new MessageListener() {
			@Override
			public void onMessage(Message message) {
				if (message instanceof TextMessage) {
					TextMessage textMessage = (TextMessage) message;
					try {
						String text = textMessage.getText();
						System.out.println(text);
					} catch (JMSException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		System.in.read();
		session.close();
		consumer.close();
		Connection.close();
	}

*/}
