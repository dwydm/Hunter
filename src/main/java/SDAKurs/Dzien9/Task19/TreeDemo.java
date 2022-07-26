package SDAKurs.Dzien9.Task19;

import java.util.ArrayList;
import java.util.List;

public class TreeDemo {
    public static void main(String[] args) {

        List<Tree> forest = fillForestWithTrees();

        for (Tree tree : forest) {
            tree.display();
        }

    }

    private static ArrayList<Tree> fillForestWithTrees() {
        List<Tree> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            if(i == 12) {
                list.add(new Tree(){
                    @Override
                    protected void display() {
                        System.out.println("Magiczne drzewo!");
                    }
                });
                continue;
            }
            list.add(new Tree());
        }

        return (ArrayList<Tree>) list;
    }
}
