package firebaseapp.com.recyclerviewextraadapter;

public class ExampleItem {

    private int mImageResource;
    private String mText1;
    private String mText2;

    public ExampleItem() {
    }

    public ExampleItem(int mImageResource, String mText1, String mText2) {
        this.mImageResource = mImageResource;
        this.mText1 = mText1;
        this.mText2 = mText2;
    }

    public void changeText1(String text){

        mText1 = text;

    }

    public int getmImageResource() {
        return mImageResource;
    }

    public void setmImageResource(int mImageResource) {
        this.mImageResource = mImageResource;
    }

    public String getmText1() {
        return mText1;
    }

    public void setmText1(String mText1) {
        this.mText1 = mText1;
    }

    public String getmText2() {
        return mText2;
    }

    public void setmText2(String mText2) {
        this.mText2 = mText2;
    }

    @Override
    public String toString() {
        return "ExampleItem{" +
                "mImageResource=" + mImageResource +
                ", mText1='" + mText1 + '\'' +
                ", mText2='" + mText2 + '\'' +
                '}';
    }
}
