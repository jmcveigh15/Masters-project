package jmcveigh15.qub.ac.uk.dawflcompanionapp;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Collection;
import java.util.List;

// this class works with the ForumMain and FreeWeek class
// it turns Firebase data into textViews which are put in a list
// it is called in the displayComments() method in the ForumMain class
public class ChatMessageAdapter extends ArrayAdapter<ChatMessage> {
    private Activity context;
    private List<ChatMessage> chatMessageList;

    // constructor with args
    public ChatMessageAdapter(Activity context, List<ChatMessage> chatMessageList) {
        super(context, R.layout.list_item, chatMessageList);
        this.context=context;
        this.chatMessageList=chatMessageList;
    }

    // this gets the listview full of the altered textviews
    @Override
    public View getView(int position,  View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listView = inflater.inflate(R.layout.list_item, null, true);

        // assigns the textviews in list_item.xml a textview variable
        TextView chatName = (TextView) listView.findViewById(R.id.message_user);
        TextView chatText = (TextView) listView.findViewById(R.id.message_text);

        ImageView userPic = (ImageView) listView.findViewById(R.id.user_pic_chat);

        // assigns the commenting user's data to the correct text/imageviews for the arraylist
        ChatMessage chatMessage = chatMessageList.get(position);

        chatName.setText(chatMessage.getMessageUser());
        chatText.setText(chatMessage.getMessageText());

        String pic = chatMessage.getMessagePic();
        Glide.with(getContext())
                    .load(pic)
                    .into(userPic);


        return listView;
    }
}
