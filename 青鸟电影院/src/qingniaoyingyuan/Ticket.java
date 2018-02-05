package qingniaoyingyuan;
/**
 * 电影票实体类
 * 
 * @author Administrator
 *
 */

public class Ticket {
	private Seat seat;	//座位
	private int price;	//票价
	private Scheduleltem scheduleltem;			//电影票信息
	
	public Ticket(){}

	//计算票价的方法
	public void compute(){
		
	}
	//输出购买的电影票
	public void print(){
		
	}
	public Seat getSeat() {
		return seat;
	}
	public void setSeat(Seat seat) {
		this.seat = seat;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Scheduleltem getScheduleltem() {
		return scheduleltem;
	}
	public void setScheduleltem(Scheduleltem scheduleltem) {
		this.scheduleltem = scheduleltem;
	}
	

}
