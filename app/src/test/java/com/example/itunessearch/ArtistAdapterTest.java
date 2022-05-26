package com.example.itunessearch;


import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import android.os.Build;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.example.itunessearch.adapters.ArtistAdapter;
import com.example.itunessearch.models.Artist;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

import java.util.Collections;
import java.util.List;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = Build.VERSION_CODES.LOLLIPOP_MR1, manifest = "app/src/main/AndroidManifest.xml")
public class ArtistAdapterTest {
    @Mock
    public ArtistAdapter.ArtistViewHolder artistViewHolder;
    @Mock
    public List<Artist> artistArrayList;
    @Mock
    public ArtistAdapter artistAdapter = new ArtistAdapter(artistArrayList);
    @Mock
    public Artist artist;

    //TestOne
//    @Test
//    public void onCreateViewHolder_createsViewHolder(){
//        artistAdapter.onCreateViewHolder(new ConstraintLayout(RuntimeEnvironment.application), 0);
//        assertThat(artistViewHolder).isNotNull();
//        assertThat(artistArrayList).isNotEmpty();
//        assertThat(artistViewHolder).isInstanceOf(ArtistAdapter.ArtistViewHolder.class);
//    }

    //TestTwo
//    @Test
//    public void onBindViewHolder_bindViewHolder(){
//        artistAdapter.setArtistArrayList(Collections.singletonList(artist));
//        ArtistAdapter.ArtistViewHolder viewHolder = mock(ArtistAdapter.ArtistViewHolder.class);
//        artistAdapter.onBindViewHolder(viewHolder, 0);
//        verify(viewHolder).onBind(artist);
//    }


}
