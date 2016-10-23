package io.github.leonhover.theme.widget;

import android.view.View;
import android.widget.ListView;

import io.github.leonhover.theme.R;
import io.github.leonhover.theme.ThemeUtils;
import io.github.leonhover.theme.model.ThemeElement;

/**
 * Created by leonhover on 16-9-27.
 */

public class ListViewWidget extends AbsListViewWidget {

    private static final String ATTR_NAME_DIVIDER = "divider";

    public ListViewWidget(Class master) {
        super(master);
        add(new ThemeElement(R.id.amt_tag_list_view_divider, ATTR_NAME_DIVIDER));
    }

    @Override
    public void appleElementTheme(View view, ThemeElement element, int attrResId) {
        super.appleElementTheme(view, element, attrResId);
        ListView listView = (ListView) view;
        if (R.id.amt_tag_list_view_divider == element.getTagKey()) {
            setDividerDrawable(listView, attrResId);
        }
    }

    private void setDividerDrawable(ListView listView, int attrResId) {

        if (listView == null) {
            return;
        }

        listView.setTag(R.id.amt_tag_list_view_divider, attrResId);

        int dividerHeight = listView.getDividerHeight();
        listView.setDivider(ThemeUtils.getDrawable(listView.getContext(), attrResId));
        listView.setDividerHeight(dividerHeight);
    }

}
