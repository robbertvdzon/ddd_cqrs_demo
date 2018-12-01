echo add users
curl -i -X POST -H "Content-Type:application/json" -d "{\"naam\":\"user1\"}" http://localhost:8080/klanten
curl -i -X POST -H "Content-Type:application/json" -d "{\"naam\":\"user2\"}" http://localhost:8080/klanten
curl -i -X POST -H "Content-Type:application/json" -d "{\"naam\":\"user3\"}" http://localhost:8080/klanten

echo add order
curl -i -X POST -H "Content-Type:application/json" -d "{\"klantId\":1}" http://localhost:8080/orders
curl -i -X POST -H "Content-Type:application/json" -d "{\"klantId\":1}" http://localhost:8080/orders

echo add orderegel
curl -i -X POST -H "Content-Type:application/json" -d "{\"productId\":1,\"orderId\":1,\"price\":10}" http://localhost:8080/orderregels
curl -i -X POST -H "Content-Type:application/json" -d "{\"productId\":2,\"orderId\":1,\"price\":23}" http://localhost:8080/orderregels
curl -i -X POST -H "Content-Type:application/json" -d "{\"productId\":3,\"orderId\":1,\"price\":7}" http://localhost:8080/orderregels
curl -i -X POST -H "Content-Type:application/json" -d "{\"productId\":2,\"orderId\":2,\"price\":7}" http://localhost:8080/orderregels

echo return all orders with productId = 2
curl http://localhost:8080/orderregels/search/findByProductId?productId=2
curl http://localhost:8080/productordercount/2
