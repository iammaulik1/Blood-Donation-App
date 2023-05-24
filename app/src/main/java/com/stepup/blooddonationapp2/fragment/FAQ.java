package com.stepup.blooddonationapp2.fragment;

import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.stepup.blooddonationapp2.Adapter.FaqAdapter;
import com.stepup.blooddonationapp2.R;
import com.stepup.blooddonationapp2.databinding.FragmentFAQBinding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class FAQ extends Fragment {

    private ExpandableListView expandableListView;
    private FaqAdapter faqAdapter;
    private List<String> groupList;
    private HashMap<String, List<String>> childList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_f_a_q, container, false);

        expandableListView = view.findViewById(R.id.expandableListView);
        prepareData();

        faqAdapter = new FaqAdapter(getActivity(), groupList, childList);
        expandableListView.setAdapter(faqAdapter);

        return view;
    }

    private void prepareData() {
        groupList = new ArrayList<>();
        childList = new HashMap<>();

        // Add group headers and child items
        groupList.add("How does the blood donation process work?");
        groupList.add("What should I do after donating blood?");
        groupList.add("Will it hurt when you insert the needle?");
        groupList.add("How long does a blood donation take?");
        groupList.add("How often can I donate blood?");
        groupList.add("Who can donate blood?");
        groupList.add("Eligibility for Donating Blood?");

        List<String> group1Items = new ArrayList<>();
        group1Items.add("Donating blood is a simple thing to do, but can make a big difference in the lives of others. The donation process from the time you arrive until the time you leave takes about an hour. The donation itself is only about 8-10 minutes on average. The steps in the process are:\n" +
                "\n" +
                "Registration :\n" +
                "\n" +
                "1. You will complete donor registration, which    includes information such as your name, address, phone number, and donor identification number (if you have one).\n" +
                "2. You will be asked to show a donor card, driver’s license or two other forms of ID.\n" +
                "\n" +
                "Health History and Mini Physical :\n" +
                "\n" +
                "1. You will answer some questions during a private and confidential interview about your health history and the places you have traveled.\n" +
                "2 .You will have your temperature, hemoglobin, blood pressure and pulse checked.\n" +
                "\n" +

                "Donation :\n" +
                "\n" +
                "1. We will cleanse an area on your arm and insert a brand–new, sterile needle for the blood draw. This feels like a quick pinch and is over in seconds.\n" +
                "2. You will have some time to relax while the bag is filling. (For a whole blood donation, it is about 8-10 minutes. If you are donating platelets, red cells or plasma by apheresis the collection can take up to 2 hours.)\n" +
                "3. When approximately a pint of blood has been collected, the donation is complete and a staff person will place a bandage on your arm. \n" +
                "\n" +
                "Refreshments :\n" +
                "\n" +
                "1. You will spend a few minutes enjoying refreshments to allow your body time to adjust to the slight decrease in fluid volume.\n" +
                "2. After 10-15 minutes you can then leave the donation site and continue with your normal daily activities.\n" +
                "3. Enjoy the feeling of accomplishment knowing that you have helped to save lives.\n" +
                "Your gift of blood may help up to three people. Donated red blood cells do not last forever. They have a shelf-life of up to 42 days. A healthy donor may donate every 56 days.");

        childList.put(groupList.get(0), group1Items);

        List<String> group2Items = new ArrayList<>();
        group2Items.add(" After you give blood:\n" +
                "\n" +
                "Take the following precautions:\n" +
                "\n" +
                "Drink an extra four glasses (eight ounces each) of non-alcoholic liquids.\n \n" +
                "Keep your bandage on and dry for the next five hours, and do not do heavy exercising or lifting.\n\n" +
                "If the needle site starts to bleed, raise your arm straight up and press on the site until the bleeding stops.\n\n" +
                "Because you could experience dizziness or loss of strength, use caution if you plan to do anything that could put you or others at risk of harm. For any hazardous occupation or hobby, follow applicable safety recommendations regarding your return to these activities following a blood donation.\n\n" +
                "Eat healthy meals and consider adding iron-rich foods to your regular diet, or discuss taking an iron supplement with your health care provider, to replace the iron lost with blood donation.\n\n" +
                "If you get a bruise:  Apply ice to the area intermittently for 10-15 minutes during the first 24 hours. Thereafter, apply warm, moist heat to the area intermittently for 10-15 minutes. A rainbow of colors may occur for about 10 days.\n\n" +
                "If you get dizzy or lightheaded:  Stop what you are doing, lie down, and raise your feet until the feeling passes and you feel well enough to safely resume activities.\n\n" +
                "And remember to enjoy the feeling of knowing you have helped save lives!\n\n" +
                "Schedule your next appointment.");

        childList.put(groupList.get(1), group2Items);

        List<String> group3Items = new ArrayList<>();
        group3Items.add(" Only for a moment. Pinch the fleshy, soft underside of your arm.\n That pinch is similar to what you will feel when the needle is inserted.");

        childList.put(groupList.get(2), group2Items);

        List<String> group4Items = new ArrayList<>();
        group4Items.add(" The entire process takes about one hour and 15 minutes; the actual donation of a pint of whole blood unit takes eight to 10 minutes.\n However, the time varies slightly with each person depending on several factors including the donor’s health history and attendance at the blood drive.");

        childList.put(groupList.get(3), group2Items);

        List<String> group5Items = new ArrayList<>();
        group5Items.add(" You must wait at least eight weeks (56 days) between donations of whole blood and 16 weeks (112 days) between Power Red donations.\n Whole blood donors can donate up to 6 times a year. \nPlatelet apheresis donors may give every 7 days up to 24 times per year. \nRegulations are different for those giving blood for themselves (autologous donors).");

        childList.put(groupList.get(4), group2Items);

        List<String> group6Items = new ArrayList<>();
        group6Items.add(" In most states, donors must be age 17 or older. \nSome states allow donation by 16-year-olds with a signed parental consent form. \nDonors must weigh at least 110 pounds and be in good health.\n Additional eligibility criteria apply.");

        childList.put(groupList.get(5), group2Items);

        List<String> group7Items = new ArrayList<>();
        group7Items.add(" Aspirin :\n\n\n Aspirin, no waiting period for donating whole blood. \nHowever, you must wait 2 full days after taking aspirin or any medication containing aspirin before donating platelets by apheresis. \nFor example, if you take aspirin products on Monday, the soonest you can donate platelets is Thursday.");
        group7Items.add("Antibiotics : \n\n\n  A donor with an acute infection can not donate. The reason for antibiotic use must be evaluated to determine if the donor has a bacterial infection that could be transmissible by blood.\n" +
                "\n" +
                "Acceptable after finishing oral antibiotics for an infection (bacterial or viral). Can have taken last pill on the date of donation. \nAntibiotic by injection for an infection acceptable 10 days after last injection. \n\nAcceptable if you are taking antibiotics to prevent an infection for the following reasons: acne, chronic prostatitis, peptic ulcer disease, periodontal disease, pre-dental work, rosacea, ulcerative colitis, after a splenectomy, or valvular heart disease. \nIf you have a temperature above 99.5 F, you can not donate.");
        group7Items.add("Birth Control : \n\n\n Individuals on oral contraceptives or using other forms of birth control are eligible to donate.");
        group7Items.add("Insulin : \n\n\n Donors with diabetes who take any kind of insulin are eligible to donate as long their diabetes is well controlled. ");

        childList.put(groupList.get(6), group2Items);


        // Add more groups and child items as needed
    }
}