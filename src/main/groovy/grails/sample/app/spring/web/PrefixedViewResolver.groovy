package grails.sample.app.spring.web

import org.springframework.web.servlet.view.AbstractUrlBasedView
import org.springframework.web.servlet.view.InternalResourceViewResolver

/**
 * ZK framework の servlet 用の特殊な prefix を持つ viewName のみを解決する ViewResolver
 */
class PrefixedViewResolver extends InternalResourceViewResolver {

  /**
   * この ViewResolver で処理可能な prefix
   */
  protected String canHandlePrefix = ""

  PrefixedViewResolver() {
  }

  PrefixedViewResolver(String canHandlePrefix) {
    this.setCanHandlePrefix(canHandlePrefix)
  }

  /**
   * この ViewResolver で処理可能な prefix をセットする
   * @param canHandlePrefix
   */
  void setCanHandlePrefix(String canHandlePrefix) {
    this.canHandlePrefix = canHandlePrefix
  }

  @Override
  protected boolean canHandle(String viewName, Locale locale) {
    return (this.hasZKPrefix(viewName) && super.canHandle(viewName, locale))
  }

  @Override
  protected AbstractUrlBasedView buildView(String viewName) throws Exception {
    assert viewName != null
    assert this.hasZKPrefix(viewName)

    String fixedViewName = viewName.substring(canHandlePrefix.length())  // zk: 以降を取得
    return super.buildView(fixedViewName)
  }

  /**
   * canHandlePrefix を持つかどうかの判定メソッド
   * @param viewName
   * @return T or F
   */
  private boolean hasZKPrefix(viewName) {
    return viewName =~ /^${canHandlePrefix}.+$/
  }
}
