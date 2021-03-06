gadgets.Tab=function(A){this.handle_=A;
this.td_=null;
this.contentContainer_=null;
this.callback_=null
};
gadgets.Tab.prototype.getName=function(){return this.td_.innerHTML
};
gadgets.Tab.prototype.getNameContainer=function(){return this.td_
};
gadgets.Tab.prototype.getContentContainer=function(){return this.contentContainer_
};
gadgets.Tab.prototype.getCallback=function(){return this.callback_
};
gadgets.Tab.prototype.getIndex=function(){var B=this.handle_.getTabs();
for(var A=0;
A<B.length;
++A){if(this===B[A]){return A
}}return -1
};
gadgets.TabSet=function(C,B,A){this.moduleId_=C||0;
this.domIdFilter_=new RegExp("^[A-Za-z]([0-9a-zA-Z_:.-]+)?$");
this.selectedTab_=null;
this.tabs_=[];
this.tabsAdded_=0;
this.defaultTabName_=B||"";
this.leftNavContainer_=null;
this.rightNavContainer_=null;
this.navTable_=null;
this.tabsContainer_=null;
this.rtl_=document.body.dir==="rtl";
this.prefs_=new gadgets.Prefs();
this.selectedTabIndex_=this.prefs_.getString("selectedTab");
this.mainContainer_=this.createMainContainer_(A);
this.tabTable_=this.createTabTable_();
this.displayTabs(false)
};
gadgets.config.register("tabset",{},function(A){gadgets.TabSet.addCSS_(A.tabs.css.join(""))
});
gadgets.TabSet.prototype.addTab=function(H,A){if(typeof A==="string"){A={contentContainer:document.getElementById(arguments[1]),callback:arguments[2]}
}var F=A||{};
var B=-1;
if(F.index>=0&&F.index<this.tabs_.length){B=F.index
}var D=this.createTab_(H,{contentContainer:F.contentContainer,callback:F.callback,tooltip:F.tooltip});
var I=this.tabTable_.rows[0];
if(this.tabs_.length>0){var G=document.createElement("td");
G.className=this.cascade_("tablib_spacerTab");
G.appendChild(document.createTextNode(" "));
var C=B<0?I.cells[I.cells.length-1]:this.tabs_[B].td_;
I.insertBefore(G,C);
I.insertBefore(D.td_,B<0?C:G)
}else{I.insertBefore(D.td_,I.cells[I.cells.length-1])
}if(B<0){B=this.tabs_.length;
this.tabs_.push(D)
}else{this.tabs_.splice(B,0,D);
this.saveSelectedTabIndex_()
}var E=parseInt(this.selectedTabIndex_,10);
if(isNaN(E)){if(H==this.defaultTabName_||(!this.defaultTabName_&&B===0)){this.selectTab_(D)
}}else{if(E==B){this.selectTab_(D,true)
}}this.tabsAdded_++;
this.displayTabs(true);
this.adjustNavigation_();
return D.contentContainer_.id
};
gadgets.TabSet.prototype.removeTab=function(A){var C=this.tabs_[A];
if(C){if(C===this.selectedTab_){var B=this.tabs_.length-1;
if(B>0){this.selectTab_(A<B?this.tabs_[A+1]:this.tabs_[A-1])
}}var D=this.tabTable_.rows[0];
if(this.tabs_.length>1){D.removeChild(A?C.td_.previousSibling:C.td_.nextSibling)
}D.removeChild(C.td_);
this.mainContainer_.removeChild(C.contentContainer_);
this.tabs_.splice(A,1);
this.adjustNavigation_();
if(this.tabs_.length===0){this.displayTabs(false);
this.selectedTab_=null
}}};
gadgets.TabSet.prototype.getSelectedTab=function(){return this.selectedTab_
};
gadgets.TabSet.prototype.setSelectedTab=function(A){if(this.tabs_[A]){this.selectTab_(this.tabs_[A])
}};
gadgets.TabSet.prototype.swapTabs=function(D,B){var C=this.tabs_[D];
var A=this.tabs_[B];
if(C&&A){var E=C.td_.parentNode;
var F=C.td_.nextSibling;
E.insertBefore(C.td_,A.td_);
E.insertBefore(A.td_,F);
this.tabs_[D]=A;
this.tabs_[B]=C
}};
gadgets.TabSet.prototype.getTabs=function(){return this.tabs_
};
gadgets.TabSet.prototype.alignTabs=function(F,B){var C=this.tabTable_.rows[0];
var D=C.cells[0];
var A=C.cells[C.cells.length-1];
var E=isNaN(B)?"3px":B+"px";
D.style.width=F==="left"?E:"";
A.style.width=F==="right"?E:"";
this.tabTable_.style.display="none";
this.tabTable_.style.display=""
};
gadgets.TabSet.prototype.displayTabs=function(A){this.mainContainer_.style.display=A?"block":"none"
};
gadgets.TabSet.prototype.getHeaderContainer=function(){return this.tabTable_
};
gadgets.TabSet.prototype.createMainContainer_=function(C){var B="tl_"+this.moduleId_;
var A=C||document.getElementById(B);
if(!A){A=document.createElement("div");
A.id=B;
document.body.insertBefore(A,document.body.firstChild)
}A.className=this.cascade_("tablib_main_container")+" "+A.className;
return A
};
gadgets.TabSet.prototype.cascade_=function(A){return A+" "+A+this.moduleId_
};
gadgets.TabSet.prototype.createTabTable_=function(){var P=document.createElement("table");
P.id=this.mainContainer_.id+"_header";
P.className=this.cascade_("tablib_table");
P.cellSpacing="0";
P.cellPadding="0";
var E=document.createElement("tbody");
var I=document.createElement("tr");
E.appendChild(I);
P.appendChild(E);
var A=document.createElement("td");
A.className=this.cascade_("tablib_emptyTab");
A.appendChild(document.createTextNode(" "));
I.appendChild(A);
I.appendChild(A.cloneNode(true));
var J=document.createElement("table");
J.id=this.mainContainer_.id+"_navTable";
J.style.width="100%";
J.cellSpacing="0";
J.cellPadding="0";
J.style.tableLayout="fixed";
var C=document.createElement("tbody");
var F=document.createElement("tr");
C.appendChild(F);
J.appendChild(C);
var D=document.createElement("td");
D.className=this.cascade_("tablib_emptyTab")+" "+this.cascade_("tablib_navContainer");
D.style.textAlign="left";
D.style.display="";
var G=document.createElement("a");
G.href="javascript:void(0)";
G.innerHTML="&laquo;";
D.appendChild(G);
F.appendChild(D);
var L=document.createElement("td");
F.appendChild(L);
var B=document.createElement("div");
B.style.width="100%";
B.style.overflow="hidden";
B.appendChild(P);
L.appendChild(B);
var K=document.createElement("td");
K.className=this.cascade_("tablib_emptyTab")+" "+this.cascade_("tablib_navContainer");
K.style.textAlign="right";
K.style.display="";
var N=document.createElement("a");
N.href="javascript:void(0)";
N.innerHTML="&raquo;";
K.appendChild(N);
F.appendChild(K);
var H=this;
G.onclick=function(Q){H.smoothScroll_(B,-120)
};
N.onclick=function(Q){H.smoothScroll_(B,120)
};
if(this.rtl_){var M=G.onclick;
G.onclick=N.onclick;
N.onclick=M
}if(this.navTable_){this.mainContainer_.replaceChild(J,this.navTable_)
}else{this.mainContainer_.insertBefore(J,this.mainContainer_.firstChild);
var O=function(){H.adjustNavigation_()
};
gadgets.util.attachBrowserEvent(window,"resize",O,false)
}this.navTable_=J;
this.leftNavContainer_=D;
this.rightNavContainer_=K;
this.tabsContainer_=B;
return P
};
gadgets.TabSet.prototype.adjustNavigation_=function(){this.leftNavContainer_.style.display="none";
this.rightNavContainer_.style.display="none";
if(this.tabsContainer_.scrollWidth<=this.tabsContainer_.offsetWidth){if(this.tabsContainer_.scrollLeft){this.tabsContainer_.scrollLeft=0
}return 
}this.leftNavContainer_.style.display="";
this.rightNavContainer_.style.display="";
if(this.tabsContainer_.scrollLeft+this.tabsContainer_.offsetWidth>this.tabsContainer_.scrollWidth){this.tabsContainer_.scrollLeft=this.tabsContainer_.scrollWidth-this.tabsContainer_.offsetWidth
}else{if(this.rtl_){this.tabsContainer_.scrollLeft=this.tabsContainer_.scrollWidth
}}};
gadgets.TabSet.prototype.smoothScroll_=function(A,F){var E=10;
if(!F){return 
}else{A.scrollLeft+=(F<0)?-E:E
}var C=Math.min(E,Math.abs(F));
var D=this;
var B=function(){D.smoothScroll_(A,(F<0)?F+C:F-C)
};
setTimeout(B,10)
};
gadgets.TabSet.addCSS_=function(C){var B=document.getElementsByTagName("head")[0];
if(B){var A=document.createElement("style");
A.type="text/css";
if(A.styleSheet){A.styleSheet.cssText=C
}else{A.appendChild(document.createTextNode(C))
}B.insertBefore(A,B.firstChild)
}};
gadgets.TabSet.prototype.createTab_=function(B,C){var A=new gadgets.Tab(this);
A.contentContainer_=C.contentContainer;
A.callback_=C.callback;
A.td_=document.createElement("td");
A.td_.title=C.tooltip||"";
A.td_.innerHTML=html_sanitize(B);
A.td_.className=this.cascade_("tablib_unselected");
A.td_.onclick=this.setSelectedTabGenerator_(A);
if(!A.contentContainer_){A.contentContainer_=document.createElement("div");
A.contentContainer_.id=this.mainContainer_.id+"_"+this.tabsAdded_;
this.mainContainer_.appendChild(A.contentContainer_)
}else{if(A.contentContainer_.parentNode!==this.mainContainer_){this.mainContainer_.appendChild(A.contentContainer_)
}}A.contentContainer_.style.display="none";
A.contentContainer_.className=this.cascade_("tablib_content_container")+" "+A.contentContainer_.className;
return A
};
gadgets.TabSet.prototype.setSelectedTabGenerator_=function(A){return function(){A.handle_.selectTab_(A)
}
};
gadgets.TabSet.prototype.selectTab_=function(C,A){if(this.selectedTab_===C){return 
}if(this.selectedTab_){this.selectedTab_.td_.className=this.cascade_("tablib_unselected");
this.selectedTab_.td_.onclick=this.setSelectedTabGenerator_(this.selectedTab_);
this.selectedTab_.contentContainer_.style.display="none"
}C.td_.className=this.cascade_("tablib_selected");
C.td_.onclick=null;
C.contentContainer_.style.display="block";
this.selectedTab_=C;
var B=(A===true)?true:false;
if(!B){this.saveSelectedTabIndex_()
}if(typeof C.callback_==="function"){C.callback_(C.contentContainer_.id)
}};
gadgets.TabSet.prototype.saveSelectedTabIndex_=function(){try{var A=this.selectedTab_.getIndex();
if(A>=0){this.selectedTabIndex_=A;
this.prefs_.set("selectedTab",A)
}}catch(B){}};
var _IG_Tabs=gadgets.TabSet;
_IG_Tabs.prototype.moveTab=_IG_Tabs.prototype.swapTabs;
_IG_Tabs.prototype.addDynamicTab=function(A,B){return this.addTab(A,{callback:B})
};