package com.stepup.blooddonationapp2.fragment;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Handler;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.android.material.card.MaterialCardView;
import com.stepup.blooddonationapp2.Activity.Chat_Activity;
import com.stepup.blooddonationapp2.Activity.ContactUs;
import com.stepup.blooddonationapp2.Activity.Donation;
import com.stepup.blooddonationapp2.Activity.Feedback;
import com.stepup.blooddonationapp2.Activity.Near_by;
import com.stepup.blooddonationapp2.Activity.PhotoAlbumActivity;
import com.stepup.blooddonationapp2.Activity.Send_Request;
import com.stepup.blooddonationapp2.Activity.VideoAlbum_Activity;
import com.stepup.blooddonationapp2.R;
import com.stepup.blooddonationapp2.Util.Image;
import com.stepup.blooddonationapp2.Util.Tools;
import com.stepup.blooddonationapp2.databinding.FragmentHomeBinding;

import java.util.ArrayList;
import java.util.List;

public class Home extends Fragment {

    FragmentHomeBinding binding;

    private ViewPager2 viewPager;
    private LinearLayout layoutDots;
    private SliderAdapter adapterImageSlider;
    private Runnable runnable = null;
    private Handler handler = new Handler();

    private static int[] arrayImagePlace = {
            R.drawable.blood_b1,
            R.drawable.blood_b2,
            R.drawable.blood_b3,
            R.drawable.blood_b4,

    };
    private AlertDialog.Builder builder;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        setHasOptionsMenu(true);

        binding.layoutSendRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), Send_Request.class));
            }
        });

        binding.layoutFeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), Feedback.class));
            }
        });

        binding.layoutVideoGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent videoactivity = new Intent(getActivity(), VideoAlbum_Activity.class);
                startActivity(videoactivity);
            }
        });

        binding.layoutChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), Chat_Activity.class));
            }
        });

        binding.layoutHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), Donation.class));
            }
        });

        binding.layoutContactus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), ContactUs.class);
                startActivity(i);
            }
        });

        binding.layoutNearby.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), Near_by.class));
            }
        });

        binding.layoutImagegallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), PhotoAlbumActivity.class));
            }
        });

        builder = new AlertDialog.Builder(getActivity());
        binding.getRoot().setFocusableInTouchMode(true);
        binding.getRoot().requestFocus();
        binding.getRoot().setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_UP) {
                    builder.setMessage("Do you want to close this application?")
                            .setCancelable(false)
                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    getFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                                    getActivity().finish();
                                }
                            })
                            .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.cancel();
                                }
                            });

                    AlertDialog alert = builder.create();
                    alert.show();

                    return true;
                }
                return false;
            }
        });

        initComponent();
        return binding.getRoot();
    }

    private void initComponent() {
        adapterImageSlider = new SliderAdapter(getActivity(), new ArrayList<Image>());
        viewPager = binding.pager;
        layoutDots = binding.layoutDots;

        final List<Image> items = new ArrayList<>();
        for (int i = 0; i < arrayImagePlace.length; i++) {
            Image obj = new Image();
            obj.image = arrayImagePlace[i];
            obj.imageDrw = getResources().getDrawable(obj.image);
            items.add(obj);
        }

        adapterImageSlider.setItems(items);
        viewPager.setAdapter(adapterImageSlider);
        /*viewPager.setPageTransformer(new CubeOutDepthTransformation());*/
        viewPager.setCurrentItem(0);
        addBottomDots(layoutDots, adapterImageSlider.getItemCount(), 0);

        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                addBottomDots(layoutDots, adapterImageSlider.getItemCount(), position);
            }
        });

        startAutoSlider(adapterImageSlider.getItemCount());
    }

    private void addBottomDots(LinearLayout layoutDots, int size, int current) {
        ImageView[] dots = new ImageView[size];

        layoutDots.removeAllViews();
        for (int i = 0; i < dots.length; i++) {
            dots[i] = new ImageView(getActivity());
            int width_height = 15;
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(width_height, width_height);
            params.setMargins(10, 10, 10, 10);
            dots[i].setLayoutParams(params);
            dots[i].setImageResource(R.drawable.shape_circle_outline);
            layoutDots.addView(dots[i]);
        }

        if (dots.length > 0) {
            dots[current].setImageResource(R.drawable.shape_circle);
        }
    }

    private void startAutoSlider(final int count) {
        runnable = new Runnable() {
            @Override
            public void run() {
                int pos = viewPager.getCurrentItem();
                pos = pos + 1;
                if (pos >= count) pos = 0;
                viewPager.setCurrentItem(pos);
                handler.postDelayed(runnable, 3000);
            }
        };
        handler.postDelayed(runnable, 3000);
    }

    private static class SliderAdapter extends RecyclerView.Adapter<SliderAdapter.ViewHolder> {

        private Activity activity;
        private List<Image> items;

        public SliderAdapter(Activity activity, List<Image> items) {
            this.activity = activity;
            this.items = items;
        }

        public void setItems(List<Image> items) {
            this.items = items;
            notifyDataSetChanged();
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_slider_image, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            final Image item = items.get(position);
            ImageView image = holder.itemView.findViewById(R.id.image);
            MaterialCardView lytParent = holder.itemView.findViewById(R.id.lyt_parent);
            Tools.displayImageOriginal(activity, image, item.image);
            lytParent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Handle click event
                }
            });
        }

        @Override
        public int getItemCount() {
            return items.size();
        }

        public static class ViewHolder extends RecyclerView.ViewHolder {
            public ViewHolder(@NonNull View itemView) {
                super(itemView);
            }
        }
    }

    @Override
    public void onDestroy() {
        if (runnable != null) handler.removeCallbacks(runnable);
        super.onDestroy();
    }
}
/*
public class Home extends Fragment {

    FragmentHomeBinding binding;

    private ViewPager viewPager;
    //private LinearLayout layout_dots;

    private Runnable runnable = null;
    private Handler handler = new Handler();

    private static int[] array_image_place = {
            R.drawable.blood_b1,
            R.drawable.blood_b2,
            R.drawable.blood_b3,
            R.drawable.blood_b4,
            R.drawable.img_s5,
    };
    private AlertDialog.Builder builder;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentHomeBinding.inflate(inflater,container,false);
        setHasOptionsMenu(true);


        binding.layoutSendRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), Send_Request.class));
            }
        });
        binding.layoutFeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), Feedback.class));
            }
        });
        binding.layoutSendRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), Send_Request.class));
            }
        });
        binding.layoutVideoGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent videoactivity = new Intent(getActivity(), VideoAlbum_Activity.class);
                startActivity(videoactivity);
            }
        });
        binding.layoutChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), Chat_Activity.class
                ));
            }
        });
        binding.layoutHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), Donation.class));
            }
        });


        binding.layoutContactus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), ContactUs.class);
                startActivity(i);
            }
        });
        binding.layoutNearby.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        binding.layoutImagegallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), PhotoAlbumActivity.class));

            }
        });


        binding.layoutNearby.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), Near_by.class));
            }
        });

        return binding.getRoot();
    }

    private class SliderAdapter extends RecyclerView.Adapter<SliderAdapter.SliderViewHolder> {

        private List<Integer> items;

        public SliderAdapter(List<Integer> items) {
            this.items = items;
        }

        @NonNull
        @Override
        public SliderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.dashboard_image_slider_item, parent, false);
            return new SliderViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull SliderViewHolder holder, int position) {
            int item = items.get(position);
            holder.imageView.setImageResource(item);
        }

        @Override
        public int getItemCount() {
            return items.size();
        }

        public class SliderViewHolder extends RecyclerView.ViewHolder {
            ImageView imageView;

            public SliderViewHolder(@NonNull View itemView) {
                super(itemView);
                imageView = itemView.findViewById(R.id.imageViewSliderItem);
            }
        }
    }

    @Override
    public void onDestroy() {
        if (runnable != null) handler.removeCallbacks(runnable);
        super.onDestroy();
    }
    }
 */

