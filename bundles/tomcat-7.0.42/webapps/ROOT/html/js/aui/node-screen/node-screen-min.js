YUI.add("node-screen",function(e,t){e.each(["winWidth","winHeight","docWidth","docHeight","docScrollX","docScrollY"],function(t){e.Node.ATTRS[t]={getter:function(){var n=Array.prototype.slice.call(arguments);return n.unshift(e.Node.getDOMNode(this)),e.DOM[t].apply(this,n)}}}),e.Node.ATTRS.scrollLeft={getter:function(){var t=e.Node.getDOMNode(this);return"scrollLeft"in t?t.scrollLeft:e.DOM.docScrollX(t)},setter:function(t){var n=e.Node.getDOMNode(this);n&&("scrollLeft"in n?n.scrollLeft=t:(n.document||n.nodeType===9)&&e.DOM._getWin(n).scrollTo(t,e.DOM.docScrollY(n)))}},e.Node.ATTRS.scrollTop={getter:function(){var t=e.Node.getDOMNode(this);return"scrollTop"in t?t.scrollTop:e.DOM.docScrollY(t)},setter:function(t){var n=e.Node.getDOMNode(this);n&&("scrollTop"in n?n.scrollTop=t:(n.document||n.nodeType===9)&&e.DOM._getWin(n).scrollTo(e.DOM.docScrollX(n),t))}},e.Node.importMethod(e.DOM,["getXY","setXY","getX","setX","getY","setY","swapXY"]),e.Node.ATTRS.region={getter:function(){var t=this.getDOMNode(),n;return t&&!t.tagName&&t.nodeType===9&&(t=t.documentElement),e.DOM.isWindow(t)?n=e.DOM.viewportRegion(t):n=e.DOM.region(t),n}},e.Node.ATTRS.viewportRegion={getter:function(){return e.DOM.viewportRegion(e.Node.getDOMNode(this))}},e.Node.importMethod(e.DOM,"inViewportRegion"),e.Node.prototype.intersect=function(t,n){var r=e.Node.getDOMNode(this);return e.instanceOf(t,e.Node)&&(t=e.Node.getDOMNode(t)),e.DOM.intersect(r,t,n)},e.Node.prototype.inRegion=function(t,n,r){var i=e.Node.getDOMNode(this);return e.instanceOf(t,e.Node)&&(t=e.Node.getDOMNode(t)),e.DOM.inRegion(i,t,n,r)}},"patched-v3.11.0",{requires:["dom-screen","node-base"]});
