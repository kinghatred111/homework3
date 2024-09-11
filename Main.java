import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

class StudyGroup {
    private String name;

    public StudyGroup(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Stream implements Iterable<StudyGroup> {
    private List<StudyGroup> groups;

    public Stream() {
        this.groups = new ArrayList<>();
    }

    public void addGroup(StudyGroup group) {
        groups.add(group);
    }

    public List<StudyGroup> getGroups() {
        return groups;
    }

    @Override
    public Iterator<StudyGroup> iterator() {
        return groups.iterator();
    }
}

class StreamComparator implements java.util.Comparator<Stream> {
    @Override
    public int compare(Stream s1, Stream s2) {
        return Integer.compare(s1.getGroups().size(), s2.getGroups().size());
    }
}

class StreamService {
    public void sortStreams(List<Stream> streams) {
        Collections.sort(streams, new StreamComparator());
    }
}

class Controller {
    private StreamService streamService;

    public Controller() {
        this.streamService = new StreamService();
    }

    public void sortStreams(List<Stream> streams) {
        streamService.sortStreams(streams);
    }
}

public class Main {
    public static void main(String[] args) {
        Stream stream1 = new Stream();
        stream1.addGroup(new StudyGroup("Группа 1"));
        stream1.addGroup(new StudyGroup("Группа 2"));

        Stream stream2 = new Stream();
        stream2.addGroup(new StudyGroup("Группа 3"));

        List<Stream> streams = new ArrayList<>();
        streams.add(stream1);
        streams.add(stream2);

        Controller controller = new Controller();
        controller.sortStreams(streams);

        for (Stream stream : streams) {
            System.out.println("Поток с " + stream.getGroups().size() + " группами");
        }
    }
}
