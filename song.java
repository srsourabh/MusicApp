
public class song {
	//create variables for name of the song and for duration of the song.
	String title;
	double duration;
	
	public song(String title , double duration){
		//constrctor
		this.title = title;
		this.duration = duration;
	}
	
	public song() {
		
	}

	public String getTitle() {
		return title;
	}

	
	public double getDuration() {
		return duration;
	}

	@Override
	public String toString() {
		return "song{" + 
					"title='" + title + '\'' + 
					", duration=" + duration +
					'}';
		
	}

}


