package wor.navapplication2

import android.os.Build
import android.support.v4.app.Fragment
import android.os.Bundle
import android.transition.Fade
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.fragment.FragmentNavigator

import kotlinx.android.synthetic.main.fragment_main_page1.*

class MainPage1Fragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_main_page1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn.setOnClickListener {
           //  Navigation.findNavController(it).navigate(R.id.action_page2)


            val kittenDetails = DemoFragment()


            /*if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                kittenDetails.setSharedElementEnterTransition(DetailsTransition())
                kittenDetails.setEnterTransition(Fade())
                exitTransition = Fade()
                kittenDetails.setSharedElementReturnTransition(DetailsTransition())
                kittenDetails.enterTransition= DetailsTransition()
            }

            activity!!.supportFragmentManager
                .beginTransaction()
                .addSharedElement(btn, "kittenImage")
                .replace(R.id.my_nav_host_fragment, kittenDetails)
                .addToBackStack(null)
                .commit()*/


            val extras = FragmentNavigator
                .Extras.Builder().addSharedElement( btn , "kittenImage").build()
            Navigation.findNavController(view).navigate(R.id.action_page1Fragment_to_demoFragment, null,null,extras)

        }
    }

}
