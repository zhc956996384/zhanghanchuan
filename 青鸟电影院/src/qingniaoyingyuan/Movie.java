package qingniaoyingyuan;
/**
 * 电影实体类
 * @author Administrator
 *
 */

public class Movie {

	private String movieName;		//电影名称
	private String poster;			//电影英文名称
	private String director;		//导演
	private String  actor;			//演员
	private MovieType movieType;	//电影类型
	private int price;			//电影票价
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getActor() {
		return actor;
	}
	public void setActor(String actor) {
		this.actor = actor;
	}
	public MovieType getMovieType() {
		return movieType;
	}
	public void setMovieType(MovieType movieType) {
		this.movieType = movieType;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

	

}
