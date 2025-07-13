class KMPlayer {
    public void play(String name) {
        System.out.println("KMPlayer is playing: " + name);
    }
}

class BluRay {
    public void play(String name) {
        System.out.println("Blu-Ray is playing " + name);
    }
}

class ZoomPlayer {
    public void play(String name) {
        System.out.println("ZoomPlayer is playing " + name);
    }
}

class Winamp {
    public void play(String name) {
        System.out.println("Winamp is playing " + name);
    }
}

class VLC {
    public void play(String name) {
        System.out.println("VLC is playing " + name);
    }
}

class MediaMonkey {
    public void play(String name) {
        System.out.println("Winamp is playing " + name);
    }
}

class CD {
    String name;
    String extension;
    String date;
    double size;

    CD(String name, String extension, String date, double size) {
        this.name = name;
        this.extension = extension;
        this.date = date;
        this.size = size;
    }

    public void cd_data() {
        System.out.println("Name: " + this.name);
        System.out.println("Extension: " + this.extension);
        System.out.println("Date: " + this.date);
        System.out.println("Size (GB): " + this.size);
    }
}

class PlayVideo extends CD{
    PlayVideo(String name, String extension, String date, double size) {
        super(name, extension, date, size);
    }

    public void controller() {
        if(extension == "mkv") {
            KMPlayer vp = new KMPlayer();
            vp.play(name);
        }
        else if(extension == "mp4") {
            BluRay vp = new BluRay();
            vp.play(name);
        }
        else if(extension == "avi") {
            ZoomPlayer vp = new ZoomPlayer();
            vp.play(name);
        }
        else {
            System.out.println("Unsupported video format");
        }
    }
}

class PlayAudio extends CD{
    PlayAudio(String name, String extension, String date, double size) {
        super(name, extension, date, size);
    }

    public void controller() {
        if(extension == "mp3") {
            MediaMonkey ap = new MediaMonkey();
            ap.play(name);
        }
        else if(extension == "wav") {
            Winamp ap = new Winamp();
            ap.play(name);
        }
        else if(extension == "flac") {
            VLC ap = new VLC();
            ap.play(name);
        }
        else {
            System.out.println("Unsupported audio format");
        }
    }
}

public class CDProject {
    public static void main(String[] args) {
        PlayAudio p1 = new PlayAudio("The Dark Knight", "mp4", "May 25, 2008", 2.3);
        p1.cd_data();
        p1.controller();

        PlayAudio p2 = new PlayAudio("Aushomapto", "mp3", "May 25, 2008", 2.3);
        p2.cd_data();
        p2.controller();
    }
}
