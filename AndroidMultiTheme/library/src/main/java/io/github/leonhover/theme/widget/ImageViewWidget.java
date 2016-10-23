package io.github.leonhover.theme.widget;

import android.view.View;
import android.widget.ImageView;

import io.github.leonhover.theme.R;
import io.github.leonhover.theme.ThemeUtils;
import io.github.leonhover.theme.model.ThemeElement;


/**
 * Created by leonhover on 16-9-27.
 */

public class ImageViewWidget extends ViewWidget {

    private static final String ATTR_NAME_SRC = "src";
    private static final String ATTR_NAME_SRC_COMPAT = "srcCompat";

    public ImageViewWidget(Class master) {
        super(master);
        add(new ThemeElement(R.id.amt_tag_image_view_src, ATTR_NAME_SRC));
        add(new ThemeElement(R.id.amt_tag_image_view_src_compat, ATTR_NAME_SRC_COMPAT));
    }

    @Override
    public void appleElementTheme(View view, ThemeElement element, int attrResId) {
        super.appleElementTheme(view, element, attrResId);
        ImageView imageView = (ImageView) view;
        if (R.id.amt_tag_image_view_src == element.getTagKey()) {
            setImageDrawable(imageView, attrResId);
        } else if (R.id.amt_tag_image_view_src_compat == element.getTagKey()) {
            setImageCompatDrawable(imageView, attrResId);
        }
    }

    public void setImageDrawable(ImageView imageView, int attrResId) {
        if (imageView == null) {
            return;
        }

        imageView.setTag(R.id.amt_tag_image_view_src, attrResId);

        imageView.setImageDrawable(ThemeUtils.getDrawable(imageView.getContext(), attrResId));
    }

    public void setImageCompatDrawable(ImageView imageView, int attrResId) {
        if (imageView == null) {
            return;
        }

        imageView.setTag(R.id.amt_tag_image_view_src_compat, attrResId);

        imageView.setImageDrawable(ThemeUtils.getDrawable(imageView.getContext(), attrResId));
    }
}
