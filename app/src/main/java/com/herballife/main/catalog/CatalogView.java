package com.herballife.main.catalog;

import com.herballife.main.base.View;
import com.herballife.main.models.Catalog;

public interface CatalogView extends View{
    void onShowFragment(Catalog catalog);
}
