/*
 * Copyright (c) Green Dot Corporation 2018-2019. All rights reserved.
 *
 */

package wor.navapplication2


import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.v4.app.Fragment
import android.transition.TransitionInflater
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewTreeObserver

/**
 * * Class: DepositCashDetailFragment
 *
 * Tile view of Deposit Cash
 *
 * @author tfredericks, hshao
 * @since 6/16/17
 */

class DemoFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            sharedElementEnterTransition = TransitionInflater.from(getContext())
//                    .inflateTransition(android.R.transition.move)

            sharedElementEnterTransition = DetailsTransition()
        }

    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val transition = TransitionInflater.from(this.activity!!).inflateTransition(android.R.transition.move)

        //  sharedElementEnterTransition = DetailsTransition()
        val view = inflater.inflate(R.layout.fragment_demo, container, false)
        val sharedview = view.findViewById<View>(R.id.image)

        sharedview.viewTreeObserver.addOnPreDrawListener(
            /*new ViewTreeObserver.OnPreDrawListener() {

        override  boolean onPreDraw() {
            // Tell the framework to start.
            sharedview.getViewTreeObserver().removeOnPreDrawListener(this);
            getActivity().startPostponedEnterTransition();
            return true;
        }
    }*/
            object : ViewTreeObserver.OnPreDrawListener {
                override fun onPreDraw(): Boolean {
                    sharedview.getViewTreeObserver().removeOnPreDrawListener(this);
                    getActivity()!!.startPostponedEnterTransition();
                    return true;
                }

            }

        )



        return view
    }

}