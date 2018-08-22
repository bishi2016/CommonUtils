package lywin.com.union.util;

import android.graphics.Rect;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;



public class RecyclerViewUtils {

    public static final int HORIZONTAL = LinearLayoutManager.HORIZONTAL;
    public static final int VERTICAL = LinearLayoutManager.VERTICAL;

    private RecyclerViewUtils() {
    }

    public static void setLinearManager(RecyclerView recyclerView){
        setLinearManagerAndAdapter(recyclerView,null);
    }

    public static void setLinearManagerAndAdapter(RecyclerView recyclerView,
                                                  RecyclerView.Adapter adapter) {
        setLinearManagerAndAdapter(recyclerView, adapter, LinearLayoutManager.VERTICAL);
    }

    public static void setLinearManagerAndAdapter(RecyclerView recyclerView,
                                                  RecyclerView.Adapter adapter, int orientation) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(recyclerView.getContext());
        linearLayoutManager.setOrientation(orientation);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(linearLayoutManager);
        if (adapter != null){
            recyclerView.setAdapter(adapter);
        }
    }

    public static void setGridManagerAndAdapter(RecyclerView recyclerView,
                                                RecyclerView.Adapter adapter, int spanCount) {
        setGridManagerAndAdapter(recyclerView,adapter,spanCount,0);
    }

    public static void setGridManagerAndAdapter(RecyclerView recyclerView,
                                                RecyclerView.Adapter adapter, int spanCount, int SpacesItemDecoration) {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(recyclerView.getContext(), spanCount);
        gridLayoutManager.setOrientation(VERTICAL);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new SpacesItemDecoration(SpacesItemDecoration));
    }

    public static void setHORIZONTALGridManagerAndAdapter(RecyclerView recyclerView,
                                                RecyclerView.Adapter adapter, int spanCount, int SpacesItemDecoration) {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(recyclerView.getContext(), spanCount);
        gridLayoutManager.setOrientation(HORIZONTAL);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new SpacesItemDecoration(SpacesItemDecoration));
    }

    public static class SpacesItemDecoration extends RecyclerView.ItemDecoration {
        private int space;

        public SpacesItemDecoration(int space) {
            this.space = space;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view,
                                   RecyclerView parent, RecyclerView.State state) {
            outRect.left = space;
            outRect.bottom = space;
        }

    }
}
