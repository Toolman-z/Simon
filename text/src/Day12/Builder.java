package Day12;

public class Builder {

	boolean buy() throws NotFullException{
		System.out.println("购买失败");
		throw new NotFullException("没有此商品");
	}

}
