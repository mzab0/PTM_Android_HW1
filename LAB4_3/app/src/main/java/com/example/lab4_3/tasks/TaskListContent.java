package com.example.lab4_3.tasks;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class TaskListContent {

    public static final List<Task> ITEMS = new ArrayList<Task>();

    public static final Map<String, Task> ITEM_MAP = new HashMap<String, Task>();

    private static final int COUNT = 1;

    static {
        // Add some sample items.
        for (int i = 1; i <= COUNT; i++) {
            addItem(createDummyItem(i));
        }
    }

    public static void addItem(Task item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.name, item);
    }
    public static void removeItem(int position)
    {
        String itemId=ITEMS.get(position).id;
        ITEMS.remove(position);
        ITEM_MAP.remove(itemId);
    }



    private static Task createDummyItem(int position) {
        return new Task(String.valueOf(position), "Item "+position, makeDetails(position), "123456789","03/08/1996","");
    }

    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        //builder.append("").append(position);
        for (int i = 0; i < position; i++) {
            builder.append("\n");
        }
        return builder.toString();
    }

    public static class Task implements Parcelable {
        public final String id;
        public final String name;
        public final String surname;
        public final String number;
        public final String birthday;
        public String picPath;

        public Task(String id, String name, String surname, String number, String birthday, String picPath) {
            this.id=id;
            this.name = name;
            this.surname = surname;
            this.number = number;
            this.birthday=birthday;
            int min=0;
            int max=7;
            int random=(int)(Math.random()*(max - min +1)+min);
            this.picPath = Integer.toString(random);
        }

        protected Task(Parcel in) {
            id=in.readString();
            name = in.readString();
            surname = in.readString();
            number = in.readString();
            birthday=in.readString();
            picPath = in.readString();
        }

        public static final Creator<Task> CREATOR = new Creator<Task>() {
            @Override
            public Task createFromParcel(Parcel in) {
                return new Task(in);
            }

            @Override
            public Task[] newArray(int size) {
                return new Task[size];
            }
        };

        @Override
        public String toString() {
            return this.name;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(id);
            dest.writeString(name);
            dest.writeString(surname);
            dest.writeString(number);
            dest.writeString(birthday);
            dest.writeString(picPath);
        }
    }
}
