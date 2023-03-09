**テーブル一覧**  
***[概要]***  
各銀行から取得したデータをそのまま保持する.  
  
◇楽天カード情報 rakuten_payout_info  
- [x] ID rakuten_id  
利用日 rakuten_use_date  
品目名 rakuten_item_name  
回数払い rakuten_pay_count  
利用金額 rakuten_money  
支払月 rakuten_pay_month  
取り込み日 capture_date  
取り込み時間 capture_time  
登録日 regist_date  
登録PRG regist_prg  
更新日 update_prg  
更新PRG update_date  
  
  
  
◇ゆうちょ銀行情報 yuucho_info  
・ID yuucho_id  
取引日 yuucho_deal_date  
入出金明細ID yuucho_detail_id  
受け入れ金額 yuucho_deposit_money  
払い出し金額 yuucho_pay_out  
詳細 yuucho_detail_1_cd  
詳細 yuucho_detail_2_cd  
現在貸付高 yuucho_present_remainder  
取り込み日 capture_date  
取り込み時間 capture_time  
登録日 regist_date  
登録PRG regist_prg  
更新日 update_prg  
更新PRG update_date  
  
  
  
◇あおぞらネット銀行情報 aozora_info  
・ID aozora_id  
日付 aozora_date  
概要 aozora_overview  
入金金額 aozora_deposit_money  
出金金額 aozora_payout_money  
残高 aozora_present_remainder  
取り込み日 capture_date  
取り込み時間 capture_time  
登録日 regist_date  
登録PRG regist_prg  
更新日 update_prg  
更新PRG update_date  
  
  
  
[概要]  
各銀行およびカード会社のデータを共通でもって管理しやすくする.  
  
◇銀行入金情報 bank_deposit_info  
・銀行情報ID bank_info_id  
・銀行区分 bank_div  
入金日付 deposit_date  
入金明細No deposit_detail_no  
入金明細名 deposit_detail_name  
入金金額 deposit_money  
登録日 regist_date  
登録PRG regist_prg  
更新日 update_prg  
更新PRG update_date  
  
  
◇銀行出金情報 bank_payout_info  
・銀行情報ID bank_info_id  
・銀行区分 bank_div  
出金日付 payout_date  
出金明細No payout_detail_no  
出金明細名 payout_detail_name  
出金金額 payout_money  
登録日 regist_date  
登録PRG regist_prg  
更新日 update_prg  
更新PRG update_date  
  
  
◇支払予定情報 pay_plan_info  
・支払予定情報ID  
・会社区分   
利用日 date  
支払予定明細No pay_plan_item_no  
支払予定金額 pay_plan_money  
支払予定月 pay_plan_month  
支払予定明細名 pay_plan_detail_name  
銀行情報ID bank_info_id  
銀行区分 bank_div  
登録日 regist_date  
登録PRG regist_prg  
更新日 update_prg  
更新PRG update_date  
  
  
◇現金入金情報 cach_deposit_info  
・ID cach_deposit_id  
取り込み日にち capture_date  
取り込み時間 capture_time  
用途(自由入力) use_content  
入金金額 cach_deposit_id  
登録日 regist_date  
登録PRG regist_prg  
更新日 update_prg  
更新PRG update_date  
  
  
  
◇現金出金情報 cach_payout_info  
・ID cach_payout_id  
取り込み日にち capture_date  
取り込み時間 capture_time  
用途(自由入力) use_content  
出金金額 payout_moneys  
登録日 regist_date  
登録PRG regist_prg  
更新日 update_prg  
更新PRG update_date  
  
  
[概要]  
マスタ情報.  
  
◇銀行マスタ  
・銀行区分  
銀行名  
  
◇カード会社マスタ  
・会社区分  
カード会社名  
  
  
[概要]  
その他  
  
◇読み込みファイル情報 read_file_info  
・ID read_file_id  
読み込み済ファイル名 already_read_file_name  
登録日 regist_date  
登録PRG regist_prg  
更新日 update_prg  
更新PRG update_date  
  
  
  
  
★大まかな仕様  
機能一覧  
  
1,銀行情報取込バッチ  
2,銀行入金情報及び銀行出金情報作成バッチ  
2-1, ゆうちょ銀行  
2-2, あおぞらネット銀行  
3, 支払予定情報作成バッチ  
3-1, 楽天カードの場合  
4, 銀行情報・支払予定情報マッチング処理バッチ  
  
  
  
1,銀行情報取込バッチ  
[概要]  
配置されているcsvファイルの情報をDBに取り込む.  
  
定義ファイルに記載されている特定のディレクトリにあるcsvファイル名を取得して保持  
保持している現在そのディレクトリにいるcsvファイル名及び全件数を全てログに出力する  
保持している現在そのディレクトリにいるcsvファイル名で読み込みファイル情報を検索  
いれば以降の処理は行わない.  
いなければ、以下の処理を行う  
バリデーションチェック  
1行目の文言でどの銀行のカード情報かを判断して以降の処理を実施する.  
"利用日","利用店名・商品名","利用者","支払方法","利用金額","支払手数料","支払総額","支払月","3月支払金額","4月繰越残高","4月以降支払金額"→楽天  
お客さま口座情報→ゆうちょ  
"日付","摘要","入金金額","出金金額","残高","メモ"：あおぞら銀行  
  
・楽天だった場合  
"2023/02/28","マスター国内利用　MZZ ﾍﾞ-ｶﾘ-ｶﾌｴｲﾁﾆｷﾕｳ","本人","1回払い","520","0","520","3月","520","0",""  
0:利用日 rakuten_use_date  
1:品目名 rakuten_item_name  
3:回数払い rakuten_pay_count  
4:利用金額 rakuten_money  
7:支払月 rakuten_pay_month  
をそれぞれdtoにセットする.  
  
・ゆうちょだった場合  
0:取引日 yuucho_deal_date  
1:入出金明細ID yuucho_detail_id  
2:受け入れ金額 yuucho_deposit_money  
3:払い出し金額 yuucho_pay_out  
4:詳細 yuucho_detail_1_cd  
5:詳細 yuucho_detail_2_cd  
6:現在貸付高 yuucho_present_remainder  
をそれぞれdtoにセットする.  
  
  
・あおぞらネット銀行だった場合  
  
0:日付 aozora_date  
1:概要 aozora_overview  
2:入金金額 aozora_deposit_money  
3:出金金額 aozora_payout_money  
4:残高 aozora_present_remainder  
をそれぞれdtoにセットする.  
  
読み込みが完了したcsvファイルをディレクトリから削除する.  
  
2,銀行入金情報及び銀行出金情報作成バッチ  
2-1, ゆうちょ銀行  
ゆうちょ銀行情報を読み込む.  
条件  
取込日及び取込時間がnullでないもの  
読み込みしたゆうちょ銀行情報を  
払い出し金額がいないレコード→入金情報  
受け入れ金額がいないレコード→出勤情報  
に分ける  
分けた入金もしくは出金情報について、日付でグルーピングしたリストのリストを作成する.  
2022-01-01  
- entity1  
- entity2  
- entity3  
  
2022-01-02  
- entity4  
- entity5  
  
2022-01-03  
- entity6  
  
--入金情報の作成.  
  
個別の日付毎に処理.  
リストを残高順の降順にソートする.  
個別のentityについて処理.  
入金明細Noのインデックスを作成する.  
  
・銀行情報ID bank_info_id  
IDを設定  
  
・銀行区分 bank_div  
「1」を設定  
  
・入金日付 deposit_date  
グルーピングしている元の日付を取得.  
  
・入金明細No deposit_detail_no  
1からスタート.設定したら+1する.  
  
・入金明細名 deposit_detail_name  
詳細1 + 詳細2  
  
・入金金額 deposit_money  
受け入れ金額を設定  
  
読み込み済DTOの作成  
DTOにIDを設定する  
DTOに銀行区分「1」を設定する  
  
  
終わったら個別entityのループ最初に戻る.  
  
  
--出金情報の作成.  
個別の日付毎に処理.  
リストを残高順の昇順にソートする.  
個別のentityについて処理.  
出金明細Noのインデックスを作成する.  
  
・銀行情報ID bank_info_id  
IDを設定  
  
・銀行区分 bank_div  
「1」を設定  
  
・出金日付 deposit_date  
グルーピングしている元の日付を取得.  
  
・出金明細No deposit_detail_no  
1からスタート.設定したら+1する.  
  
・出金明細名 deposit_detail_name  
詳細1 + 詳細2  
  
・出金金額 deposit_money  
払出し金額を設定  
  
支払予定情報取込済フラグ pay_plan_info_already_captured_flg  
カード会社に紐づく支払いの場合、falseを選択  
それ以外はnullを選択.  
  
読み込み済DTOの作成  
DTOにIDを設定する  
DTOに銀行区分「1」を設定する  
  
終わったら個別entityのループ最初に戻る.  
  
  
  
2-2, あおぞらネット銀行.  
 あおぞらネット銀行情報を読み込む.  
条件  
取込日及び取込時間がnullでないもの  
読み込みした あおぞらネット銀行情報を  
払い出し金額がいないレコード→入金情報  
受け入れ金額がいないレコード→出勤情報  
に分ける  
分けた入金もしくは出金情報について、日付でグルーピングしたリストのリストを作成する.  
2022-01-01  
- entity1  
- entity2  
- entity3  
  
2022-01-02  
- entity4  
- entity5  
  
2022-01-03  
- entity6  
  
--入金情報の作成.  
  
個別の日付毎に処理.  
リストを残高順の降順にソートする.  
個別のentityについて処理.  
入金明細Noのインデックスを作成する.  
  
・銀行情報ID bank_info_id  
IDを設定  
  
・銀行区分 bank_div  
「2」を設定  
  
・入金日付 deposit_date  
グルーピングしている元の日付を取得.  
  
・入金明細No deposit_detail_no  
1からスタート.設定したら+1する.  
  
・入金明細名 deposit_detail_name  
概要  
  
・入金金額 deposit_money  
入金金額を設定  
  
読み込み済DTOの作成  
DTOにIDを設定する  
DTOに銀行区分「2」を設定する  
  
  
終わったら個別entityのループ最初に戻る.  
  
  
--出金情報の作成.  
個別の日付毎に処理.  
リストを残高順の昇順にソートする.  
個別のentityについて処理.  
出金明細Noのインデックスを作成する.  
  
・銀行情報ID bank_info_id  
IDを設定  
  
・銀行区分 bank_div  
「2」を設定  
  
・出金日付 deposit_date  
グルーピングしている元の日付を取得.  
  
・出金明細No deposit_detail_no  
1からスタート.設定したら+1する.  
  
・出金明細名 deposit_detail_name  
概要  
  
・出金金額 deposit_money  
出金金額を設定  
  
支払予定情報取込済フラグ pay_plan_info_already_captured_flg  
カード会社に紐づく支払いの場合、falseを選択  
それ以外はnullを選択.  
  
読み込み済DTOの作成  
DTOにIDを設定する  
DTOに銀行区分「1」を設定する  
  
終わったら個別entityのループ最初に戻る.  
  
  
◇支払予定情報  
・支払予定情報ID  
・会社区分   
利用日 date  
支払予定明細No pay_plan_item_no  
支払予定金額 pay_plan_money  
支払予定月 pay_plan_month  
銀行情報ID bank_info_id  
銀行区分 bank_div  
登録日 regist_date  
登録PRG regist_prg  
更新日 update_prg  
更新PRG update_date  
  
3, 支払予定情報作成バッチ  
3-1, 楽天カードの場合  
  
楽天カード情報を読み込む.  
条件  
取込日及び取込時間がnullでないもの  
分けた入金もしくは出金情報について、日付でグルーピングしたリストのリストを作成する.  
2022-01-01  
- entity1  
- entity2  
- entity3  
  
2022-01-02  
- entity4  
- entity5  
  
2022-01-03  
- entity6  
  
--入金情報の作成.  
  
個別の日付毎に処理.  
リストを残高順の降順にソートする.  
個別のentityについて処理.  
支払予定明細Noのインデックスを作成する.  
  
・支払予定情報ID  
IDを設定  
  
・会社区分  bank_div  
「1」を設定  
  
・利用日 date  
利用日を設定  
  
・支払予定明細No pay_plan_item_no  
インデックスを設定　終わったら+1  
  
・支払予定金額 pay_plan_money  
金額を設定  
  
  
・支払予定月 pay_plan_month  
月を設定  
  
・銀行情報ID bank_info_id  
・銀行区分 bank_div  
nullを設定  
  
  
読み込み済DTOの作成  
DTOにIDを設定する  
DTOに銀行区分「1」を設定する  
  
終わったら個別entityのループ最初に戻る.  
  
  
  
4, 銀行情報・支払予定情報マッチング処理バッチ  
例  
3/9時点でマッチングを走らせた場合  
想定されるデータ  
(取込済データ)  
1/1  
1/2  
1/3  
.....  
1/31  
(/取込済データ)  
(未取込データ1)  
2/1  
2/2  
......  
2/28  
(/未取込データ1)  
(未取込データ2)  
3/1  
3/2  
......  
3/9  
(/未取込データ2)  
  
・取込済データ  
1/1~1/31の支払予定データ。  
正常に動いていれば、2/27の時点で取込が完了しているはず。  
  
・未取込データ1  
2/1~2/28の支払予定データ。  
正常に動いた場合、3/27の時点で取り込みが完了する  
→今回マッチング処理を走らせたい対象のデータ。  
  
  
・未取込データ2  
3/1~3/9の支払予定データ。  
正常に動いた場合、4/27の時点で取り込みが完了する  
→未来分なので、まだ何もしない。  
  
  
  
・検証処理  
1, 前々月以前の支払予定情報の取込が完了しているかを検証する。  
  
銀行ID及び銀行区分でnullのデータが前々月以前にいるかどうかを判定。  
取り込みできていないデータがいる場合、マッチング処理は行わない。  
(上記の例で言うと、1/1~1/31のデータもしくはそれ以前の12月11月とかのデータ)  
  
2,前々月の検証がうまくいった場合は、前月から今日までのデータの取込が行われていないことを検証する。  
取込されているデータがいた場合は、マッチング処理は行わない。  
(2,3月のデータが対象になる)  
  
・マッチング処理  
1, 銀行出金情報から有効なデータを取ってくる  
前月の銀行出金情報を検索して、楽天からの引き落としがありそうなデータを詳細の文字列からサーチする。  
いない場合はマッチング処理は行わない。  
  
2, 有効なデータがいた場合、金額のチェックを行う  
いた場合は、支払予定情報の前月のデータのリストを取得してくる  
データリストの合計を取得→有効なデータの金額とマッチングする  
金額が一致すれば銀行ID及び銀行区分を設定する処理を行う  
  
3,   
前月データリストのループを開始する  
金額が一致すれば銀行ID及び銀行区分を設定する処理を行う  
  
