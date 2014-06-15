package ph.main;

import java.io.File;

import ph.utils.CONS;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.os.Build;

public class MainActv extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actv_main);

        this.setTitle(this.getClass().getName());
        
//        if (savedInstanceState == null) {
//            getSupportFragmentManager().beginTransaction()
//                    .add(R.id.container, new PlaceholderFragment())
//                    .commit();
//        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_actv, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.frag_actv_main, container, false);
            return rootView;
        }
    }

    protected void onStart() {
		/*********************************
		 * 1. Show list
		 * 
//		 * 1. Refresh list view;
		 *********************************/
//		/*********************************
//		 * 1. Show list
//		 *********************************/
		super.onStart();
		
		// Log
		String msg_Log = "onStart()";
		Log.d("MainActv.java" + "["
				+ Thread.currentThread().getStackTrace()[2].getLineNumber()
				+ "]", msg_Log);
		
		_test_D_2_V_2_0();
		
	}//protected void onStart()


	private void
	_test_D_2_V_2_0() {
		// TODO Auto-generated method stub
		
//		File dpath_SDCard = new File(CONS.Paths.dpath_Storage_Internal);
//		
//		String[] fnames = dpath_SDCard.list();
//		
//		for (String name : fnames) {
//			
//			// Log
//			String msg_Log = String.format("name = %s", name);
//			Log.d("MainActv.java" + "["
//					+ Thread.currentThread().getStackTrace()[2].getLineNumber()
//					+ "]", msg_Log);
//			
//		}
		
		////////////////////////////////

		// list in "Pictures"

		////////////////////////////////
		File dpath_Pictures = new File(
						CONS.Paths.dpath_Storage_Internal,
						CONS.Paths.dname_Pictures);
		
		if (!dpath_Pictures.exists()) {
			
			// Log
			String msg_Log = String.format(
							"Dir => not exist: %s",
							dpath_Pictures.getAbsolutePath());
			
			Log.d("MainActv.java" + "["
					+ Thread.currentThread().getStackTrace()[2].getLineNumber()
					+ "]", msg_Log);
			
			return;
			
		}		
		
//		String[] pictNames = dpath_Pictures.list();
//		
//		// Log
//		String msg_Log = "pictNames.length = " + pictNames.length;
//		Log.d("MainActv.java" + "["
//				+ Thread.currentThread().getStackTrace()[2].getLineNumber()
//				+ "]", msg_Log);
//		
//		
//		for (String name : pictNames) {
//			
//			// Log
//			msg_Log = String.format("name = %s", name);
//			Log.d("MainActv.java" + "["
//					+ Thread.currentThread().getStackTrace()[2].getLineNumber()
//					+ "]", msg_Log);
//			
//		}
//		
		////////////////////////////////

		// set: image

		////////////////////////////////
//		File fPict = new File(pictNames[0]);
		File[] fpath_Pictures = dpath_Pictures.listFiles();
		
		Bitmap bm = BitmapFactory.decodeFile(fpath_Pictures[0].getAbsolutePath());
		
		Bitmap bm_Modified = _modify_Bitmap(bm);

		ImageView iv = (ImageView) this.findViewById(R.id.actv_main_iv);
		
		iv.setImageBitmap(bm_Modified);
		
		
	}//_test_D_2_V_2_0()


	private Bitmap _modify_Bitmap(Bitmap bm) {
		// TODO Auto-generated method stub
		int bm_w = bm.getWidth();
		int bm_h = bm.getHeight();
		
		Display disp=((WindowManager)getSystemService(
				Context.WINDOW_SERVICE)).getDefaultDisplay();
		
		Point point = new Point();
		
		disp.getSize(point);
		
		int disp_Height = point.y;
		int disp_Width = point.x;
		
//		// Log
//		String msg_Log = "point.y = " + point.y
//						+ " , "
//						+ "point.x = " + point.x;
//		
//		Log.d("MainActv.java" + "["
//				+ Thread.currentThread().getStackTrace()[2].getLineNumber()
//				+ "]", msg_Log);
//		
//		msg_Log = "disp.getHeight() = " + disp.getHeight()
//				+ " , "
//				+ "disp.getWidth() = " + disp.getWidth();
//		
//		Log.d("MainActv.java" + "["
//				+ Thread.currentThread().getStackTrace()[2].getLineNumber()
//				+ "]", msg_Log);
		
		
		int w;
		int h;
		
		if (bm_w > bm_h) {
			
			h = disp_Height;
//			h = disp.getHeight();
			
			w = (int) (h * ((float) bm_w / bm_h));
			
//			w = disp.getWidth();
//			
//			h = (int) (w * ((float) bm_h / bm_w));
			
		} else {//if (bm_w > bm_h)
			
			w = disp_Width;
//			w = disp.getWidth();
			
			h = (int) (w * ((float) bm_h / bm_w));
			
//			h = disp.getHeight();
//			
//			w = (int) (h * ((float) bm_w / bm_h));
			
		}//if (bm_w > bm_h)
		
		
//		int w=disp.getWidth();
//		int h=disp.getHeight();

		// resize
		w = w / 2;
		h = h / 2;
		
		return Bitmap.createScaledBitmap(bm, w, h, false);
		
	}//private Bitmap _modify_Bitmap(Bitmap bm)
    
}
