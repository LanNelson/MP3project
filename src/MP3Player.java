package src;

public class MP3Player
{
	public static void main(String[] args)
	{
		Library lib = new Library();
		PlayList playList = new PlayList(lib);
		new MP3PlayerView(new MP3PlayerModel(lib,playList), lib, playList);
	}
}
